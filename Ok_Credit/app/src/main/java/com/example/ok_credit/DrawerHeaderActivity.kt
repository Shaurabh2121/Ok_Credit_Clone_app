package com.example.ok_credit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.ok_credit.database.MyDatabase
import com.example.ok_credit.database.ProfileDatabase.ProfileEntity
import kotlinx.android.synthetic.main.activity_drawer_header.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Entity

class DrawerHeaderActivity : AppCompatActivity() {
    private val TAG = "DrawerHeaderActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_header)
        Log.d(TAG, "onCreate: ")
            val data= MyDatabase.getDatabase(this@DrawerHeaderActivity).getProfileDataDao()
            data.getData().observe(this@DrawerHeaderActivity, Observer {sk->
//                Log.d(TAG, "onCreate: Hii sibtain kese ho hfdhfdjkvb "+sk[0])
//                Log.d(TAG, "onCreate: Hii sibtain kese ho hfdhfdjkvb"+sk[0])
                tvName.text = sk[0].name
                tvPhoneNumber.text = sk[0].phoneNumber
            })

    }
}