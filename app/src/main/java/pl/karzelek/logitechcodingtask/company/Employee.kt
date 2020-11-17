package pl.karzelek.logitechcodingtask.company

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class Employee(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var employeeId: Long?,

    @ColumnInfo(name = "boss_id")
    var bossId: Long?,

    @ColumnInfo(name = "name", collate = ColumnInfo.NOCASE)
    var name: String?,

    @ColumnInfo(name = "age")
    var age: Int?,

    @Embedded
    var address: Address?,
)