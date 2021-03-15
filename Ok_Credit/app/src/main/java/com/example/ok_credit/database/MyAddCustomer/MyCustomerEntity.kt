package com.example.ok_credit.database.MyAddCustomer

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyCustomerEntity(
    val name:String,
    val phoneNumber:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}