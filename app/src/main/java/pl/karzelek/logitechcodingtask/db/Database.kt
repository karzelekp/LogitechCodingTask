package pl.karzelek.logitechcodingtask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.karzelek.logitechcodingtask.company.Address
import pl.karzelek.logitechcodingtask.company.Employee
import pl.karzelek.logitechcodingtask.company.Report

@Database(entities = [Employee::class, Report::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao
    abstract fun reportDao(): ReportDao

    companion object {
        const val NAME = "coding_task.db"
    }
}
