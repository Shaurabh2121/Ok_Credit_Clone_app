package com.example.ok_credit.database.SupplierChatBot

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SuppllierChatEnity(
    var Amount:String,
    var typeId:String,
    var time:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
}