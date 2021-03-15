package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ok_credit.BaseFragment
import com.example.ok_credit.R
import com.example.ok_credit.database.MyAddCustomer.MyCustomerEntity
import com.example.ok_credit.database.MyDatabase
import kotlinx.android.synthetic.main.fragment_add_customer.*
import kotlinx.coroutines.launch


class AddCustomerFragment : BaseFragment() {

    private var myCustomerEntity:MyCustomerEntity?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_customer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addplusCustomer.setOnClickListener { view ->
            val name = etNameCustomer.text.toString().trim()
            val number = etNumberCustomer.text.toString().trim()
            if (name.isEmpty()) {
                etNameCustomer.error = "Name required"
                etNameCustomer.requestFocus()
                return@setOnClickListener
            }
            if (number.isEmpty()) {
                etNumberCustomer.error = "Number required"
                etNameCustomer.requestFocus()
                return@setOnClickListener
            }
            launch {
                context?.let {
                    val myCustomerEntity = MyCustomerEntity(name, number)
                    MyDatabase.getDatabase(it).getMyCustomerDao().insert(myCustomerEntity)
                    Toast.makeText(context, "Contact saved", Toast.LENGTH_LONG).show()

                }
            }
            val action =AddCustomerFragmentDirections.actionGlobalCustomerFragment()
            findNavController().navigate(action)
        }
    }
}