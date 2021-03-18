package com.example.ok_credit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ok_credit.database.MyAddCustomer.MyCustomerDao
import com.example.ok_credit.database.MyAddCustomer.MyCustomerEntity
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierDao
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierEntity
import com.example.ok_credit.database.ProfileDatabase.ProfileDao
import com.example.ok_credit.database.ProfileDatabase.ProfileEntity
import com.example.ok_credit.database.SupplierChatBot.SupplierChatDao
import com.example.ok_credit.database.SupplierChatBot.SuppllierChatEnity

@Database(entities = [MyCustomerEntity::class,MyAddSupplierEntity::class,ProfileEntity::class,SuppllierChatEnity::class],version = 3,exportSchema = false)
 abstract class MyDatabase():RoomDatabase() {
    abstract fun getMyCustomerDao(): MyCustomerDao
    abstract fun getMyAddSupplierDao(): MyAddSupplierDao
    abstract fun getProfileDataDao():ProfileDao
    abstract fun getSupplierChatDao():SupplierChatDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.

            private var INSTANCE:MyDatabase?=null
            fun getDatabase(context: Context):MyDatabase{
                if(INSTANCE==null){
                    val builder:Builder<MyDatabase> = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "Data_database"
                    )
                    builder.fallbackToDestructiveMigration()
                    return builder.build()
                    return INSTANCE!!
                }else{
                    return INSTANCE!!
                }
            }
        }
}