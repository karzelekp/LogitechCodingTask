package pl.karzelek.logitechcodingtask.company

import androidx.room.ColumnInfo

data class Address(
    @ColumnInfo(name = "street")
    val street: String?,

    @ColumnInfo(name = "suite")
    val suite: String?,

    @ColumnInfo(name = "city")
    val city: String?,

    @ColumnInfo(name = "zip_code")
    val zipCode: String?,
)