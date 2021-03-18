package com.example.ok_credit.database.SupplierChatBot

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SupplierChatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(supplierChatEnity: SuppllierChatEnity)

    @Query("SELECT * FROM suppllierchatenity order by id DESC")
    fun getData(): MutableList<SuppllierChatEnity>

}