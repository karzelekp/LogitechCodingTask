package pl.karzelek.logitechcodingtask.ui.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch
import pl.karzelek.logitechcodingtask.company.Employee
import pl.karzelek.logitechcodingtask.company.Report
import pl.karzelek.logitechcodingtask.db.TaskDatabase

class MainViewModel : ViewModel() {

    fun x(context: Context) {

        val taskDatabase = Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            TaskDatabase.NAME
        ).build()


        taskDatabase.employeeDao().getEmployeesWithReports().observeForever {
            Log.d("asdf", "employee: $it")
        }

        viewModelScope.launch {
            taskDatabase.employeeDao().insertAll(
                listOf(
                    Employee(1, 2, 20, null)
                )
            )
            taskDatabase.reportDao().insertAll(
                listOf(
                    Report(2, 1, "report content")
                )
            )
        }

        //todo provide test data (with John etc)
    }
}