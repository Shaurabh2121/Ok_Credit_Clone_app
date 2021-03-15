package com.example.ok_credit.database.MyAddSupplier

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyAddSupplierEntity  (
    var name:String,
    var phoneNumber:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}