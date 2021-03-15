package com.example.ok_credit.database.MyAddCustomer

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyCustomerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(myCustomerEntity: MyCustomerEntity)

    @Query("SELECT * FROM mycustomerentity order by id DESC")
    fun getData(): LiveData<List<MyCustomerEntity>>

    @Update
    suspend fun updateData(myCustomerEntity: MyCustomerEntity)

    @Delete
    suspend fun deleteData(myCustomerEntity: MyCustomerEntity)
}