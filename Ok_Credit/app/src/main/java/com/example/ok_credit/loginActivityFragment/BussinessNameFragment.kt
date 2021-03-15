package com.example.ok_credit.loginActivityFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ok_credit.BaseFragment
import com.example.ok_credit.R
import com.example.ok_credit.database.MyAddCustomer.MyCustomerEntity
import com.example.ok_credit.database.MyDatabase
import com.example.ok_credit.database.ProfileDatabase.ProfileEntity
import kotlinx.android.synthetic.main.fragment_add_customer.*
import kotlinx.android.synthetic.main.fragment_bussiness_name.*
import kotlinx.coroutines.launch

class BussinessNameFragment : BaseFragment() {
    private val args: BussinessNameFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bussiness_name, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        confrimBusinessName.setOnClickListener {
            val number = args.number
            val name = etBusinessName.text.toString().trim()
            if (name.isEmpty()) {
                etBusinessName.error = "Name required"
                etBusinessName.requestFocus()
                return@setOnClickListener
            }
                launch {
                    context?.let {
                        val profileEntity=ProfileEntity(name,number)
                        MyDatabase.getDatabase(it).getProfileDataDao().insert(profileEntity)
                        Toast.makeText(context, "Contact saved", Toast.LENGTH_LONG).show()

                    }
                }

                val action = BussinessNameFragmentDirections.actionBussinessNameFragmentToHomeActivity()
                findNavController().navigate(action)
            }
        }






}