package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.ok_credit.BaseFragment
import com.example.ok_credit.R
import com.example.ok_credit.database.MVVM.MyAddSupplierViewModel
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierEntity
import kotlinx.android.synthetic.main.fragment_add_supplier.*
import kotlinx.coroutines.launch

class AddSupplierFragment : BaseFragment() {
private lateinit var viewModel:MyAddSupplierViewModel
private var myAddSupplierEntity:MyAddSupplierEntity?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_supplier, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel= ViewModelProviders.of(this).get(MyAddSupplierViewModel::class.java)


        addPlusSupplier.setOnClickListener {
            val name=etNameSupp.text.toString().trim()
            val phoneNumber=etNumberSupp.text.toString().trim()
            if (name.isEmpty()) {
                etNameSupp.error = "title required"
                etNameSupp.requestFocus()
                return@setOnClickListener
            }
            if (phoneNumber.isEmpty()) {
                etNumberSupp.error = "note required"
                etNumberSupp.requestFocus()
                return@setOnClickListener
            }
            launch {
                context?.let {
                    val myAddSupplierEntity=MyAddSupplierEntity(name, phoneNumber)
                     viewModel.insertNote(myAddSupplierEntity)
                     Toast.makeText(context, "Contact saved", Toast.LENGTH_LONG).show()


                }
            }
            val action=AddCustomerFragmentDirections.actionGlobalSupplierFragment()
            findNavController().navigate(action)
        }
    }
}