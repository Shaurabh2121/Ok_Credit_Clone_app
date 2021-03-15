package com.example.ok_credit.database.MVVM

import androidx.lifecycle.LiveData
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierDao
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyAddSupplierRepository(val myAddSupplierDao: MyAddSupplierDao) {
    fun addTask(myAddSupplierEntity: MyAddSupplierEntity){
        CoroutineScope(Dispatchers.IO).launch {
            myAddSupplierDao.insert(myAddSupplierEntity)
        }
    }
    fun getTask(): LiveData<List<MyAddSupplierEntity>> {
        return myAddSupplierDao.getData()
    }

    fun updateTask(myAddSupplierEntity: MyAddSupplierEntity){
        CoroutineScope(Dispatchers.IO).launch {
            myAddSupplierDao.updateData(myAddSupplierEntity)
        }
    }
    fun deleteTask(myAddSupplierEntity: MyAddSupplierEntity){
        CoroutineScope(Dispatchers.IO).launch {
            myAddSupplierDao.deleteData(myAddSupplierEntity)
        }
    }
}