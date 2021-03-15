package com.example.ok_credit.database.ProfileDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ProfileEntity (
        val name:String,
        val phoneNumber:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0


}