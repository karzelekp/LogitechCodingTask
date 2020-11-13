package pl.karzelek.logitechcodingtask.db

import androidx.room.Embedded
import androidx.room.Relation
import pl.karzelek.logitechcodingtask.company.Employee
import pl.karzelek.logitechcodingtask.company.Report

data class EmployeeWithReports(
    @Embedded
    val employee: Employee,

    @Relation(entity = Report::class, parentColumn = "id", entityColumn = "employee_id")
    val reports: List<Report>
)