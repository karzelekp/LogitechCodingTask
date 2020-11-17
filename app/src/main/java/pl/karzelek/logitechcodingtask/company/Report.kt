package pl.karzelek.logitechcodingtask.company

import androidx.room.*

@Entity(
    tableName = "reports",
    foreignKeys = [
        ForeignKey(
            entity = Employee::class,
            parentColumns = ["id"],
            childColumns = ["employee_id"],
            onDelete = ForeignKey.CASCADE
        ),
    ],
    indices = [
        Index("employee_id")
    ]
)
data class Report(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long?,

    @ColumnInfo(name = "employee_id")
    var employeeId: Long?,

    @ColumnInfo(name = "content")
    var content: String?
)