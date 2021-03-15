package com.example.ok_credit.database.MVVM

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierEntity
import com.example.ok_credit.database.MyDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyAddSupplierViewModel( application: Application) : AndroidViewModel(application) {
    private val repository:MyAddSupplierRepository
    val getTask: LiveData<List<MyAddSupplierEntity>>
    init {
        val dao=MyDatabase.getDatabase(application).getMyAddSupplierDao()
        repository= MyAddSupplierRepository(dao)
        getTask=repository.getTask()
    }


    fun deleteNote(myAddSupplierEntity: MyAddSupplierEntity)= viewModelScope.launch (Dispatchers.IO){
        repository.deleteTask(myAddSupplierEntity)
    }
    fun insertNote(myAddSupplierEntity: MyAddSupplierEntity)= viewModelScope.launch (Dispatchers.IO){
        repository.addTask(myAddSupplierEntity)
    }
    fun updateNote(myAddSupplierEntity: MyAddSupplierEntity)= viewModelScope.launch (Dispatchers.IO){
        repository.updateTask(myAddSupplierEntity)
    }
}