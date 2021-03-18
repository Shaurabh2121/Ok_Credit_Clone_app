package com.example.ok_credit.database.ProfileDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ok_credit.database.MyAddCustomer.MyCustomerEntity

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(profileEntity: ProfileEntity)

    @Query("SELECT * FROM profileentity order by id DESC")
    fun getData(): LiveData<MutableList<ProfileEntity>>

    @Update
    suspend fun updateData(profileEntity: ProfileEntity)

    @Delete
    suspend fun deleteData(profileEntity: ProfileEntity)
}