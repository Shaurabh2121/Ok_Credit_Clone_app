package com.example.ok_credit.database.MyAddSupplier

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.ok_credit.database.MyAddCustomer.MyCustomerEntity

@Dao
interface MyAddSupplierDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(myAddSupplierEntity: MyAddSupplierEntity)

    @Query("SELECT * FROM myaddsupplierentity order by id DESC")
    fun getData(): LiveData<List<MyAddSupplierEntity>>

    @Update
    suspend fun updateData(myAddSupplierEntity: MyAddSupplierEntity)

    @Delete
    suspend fun deleteData(myAddSupplierEntity: MyAddSupplierEntity)
}