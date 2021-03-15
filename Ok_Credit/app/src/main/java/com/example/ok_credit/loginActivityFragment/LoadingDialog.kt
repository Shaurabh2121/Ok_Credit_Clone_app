package com.example.ok_credit.loginActivityFragment

import android.app.AlertDialog
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.ok_credit.R

class LoadingDialog(private var  fragment: Fragment) {
 private lateinit var alertDialod :AlertDialog


  fun startLoadingDialog(){
      val builder =AlertDialog.Builder(fragment.context)
      val inflater=fragment.layoutInflater
      builder.setView(inflater.inflate(R.layout.custom_dailog,null))
      builder.setCancelable(false)

      alertDialod=builder.create()
      alertDialod.show()
  }
    fun dismissDialog(){
        alertDialod.dismiss()
    }
}