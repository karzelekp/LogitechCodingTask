package pl.karzelek.logitechcodingtask.company

import androidx.room.ColumnInfo

data class Address(
    @ColumnInfo(name = "street")
    var street: String?,

    @ColumnInfo(name = "suite")
    var suite: String?,

    @ColumnInfo(name = "city")
    var city: String?,

    @ColumnInfo(name = "zip_code")
    var zipCode: String?,
)