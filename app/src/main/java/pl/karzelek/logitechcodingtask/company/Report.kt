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
    val id: Int,

    @ColumnInfo(name = "employee_id")
    val employeeId: Int,

    @ColumnInfo(name = "content")
    val content: String
)