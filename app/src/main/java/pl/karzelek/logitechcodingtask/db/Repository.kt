package pl.karzelek.logitechcodingtask.db

import android.util.Log
import pl.karzelek.logitechcodingtask.App
import pl.karzelek.logitechcodingtask.company.Address
import pl.karzelek.logitechcodingtask.company.Employee
import pl.karzelek.logitechcodingtask.company.Report
import pl.karzelek.logitechcodingtask.extensions.clearAllTablesSuspend
import pl.karzelek.logitechcodingtask.extensions.runInTransactionSuspend

class Repository(private val application: App) {

    val johnEmployeesLiveData = application.database.employeeDao().getEmployeesWithReports(
        SEARCH_PHRASE
    )

    suspend fun saveTestData() {
        application.database.clearAllTablesSuspend()
        Log.d(CLASS_STRUCTURE_TAG, "clearing all tables")
        val dao = application.database.employeeDao()

        val john = Employee(
            null,
            null,
            "John",
            40,
            Address(
                "Legnicka",
                "suite",
                "Wrocław",
                "53-426"
            )
        )
        EmployeeWithReports(john, listOf(Report(null, null, "content"))).save()

        val mary = Employee(null, john.employeeId, "Mary", 20, null)
        val peter = Employee(null, john.employeeId, "Peter", 25, null)
        val michael = Employee(null, john.employeeId, "Michael", 30, null)
        dao.insertAndUpdateId(mary, peter, michael)

        val sam = Employee(null, mary.employeeId, "Sam", 20, null)
        val will = Employee(null, mary.employeeId, "Will", 30, null)
        dao.insertAndUpdateId(sam, will)

        val jackie = Employee(null, will.employeeId, "Jackie", 40, null)
        val frank = Employee(null, will.employeeId, "Frank", 26, null)
        dao.insertAndUpdateId(jackie, frank)
    }

    private suspend fun EmployeeWithReports.save() = application.database.also { db ->
        db.runInTransactionSuspend {
            db.employeeDao().insertAndUpdateId(employee)
            reports.forEach {
                it.employeeId = employee.employeeId
            }
            Log.d(CLASS_STRUCTURE_TAG, "writing into database: $reports")
            db.reportDao().insertAll(reports)
        }
    }
}

const val SEARCH_PHRASE = "john"
const val CLASS_STRUCTURE_TAG = "class_structure"