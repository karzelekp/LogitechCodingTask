package pl.karzelek.logitechcodingtask.company

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CEO_ID = -1

@Entity(tableName = "employees")
data class Employee(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val employeeId: Int?,

    @ColumnInfo(name = "boss_id")
    val bossId: Int?,

    @ColumnInfo(name = "age")
    val age: Int?,

    @Embedded
    val address: Address?,
)