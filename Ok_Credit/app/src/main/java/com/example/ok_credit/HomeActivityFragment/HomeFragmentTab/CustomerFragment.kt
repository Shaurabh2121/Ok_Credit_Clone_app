package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ok_credit.BaseFragment
import com.example.ok_credit.R
import com.example.ok_credit.database.MyAddCustomer.CustomerItemClickListener
import com.example.ok_credit.database.MyAddCustomer.MyCustomerEntity
import com.example.ok_credit.database.MyDatabase
import kotlinx.android.synthetic.main.fragment_customer.*
import kotlinx.android.synthetic.main.fragment_supplier.*
import kotlinx.coroutines.launch


class CustomerFragment : BaseFragment(),CustomerItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        customRecyclerView.setHasFixedSize(true)
        customRecyclerView.layoutManager= LinearLayoutManager(context)

        launch {
           context?.let {sk ->
               val data=MyDatabase.getDatabase(sk).getMyCustomerDao().getData()
               data.observe(viewLifecycleOwner, Observer {
                   customRecyclerView.adapter=CustomerAdpter(it,this@CustomerFragment)
               })

           }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addCustomerLinear.setOnClickListener {
            val action=CustomerFragmentDirections.actionGlobalAddCustomerFragment()
            findNavController().navigate(action)
        }
    }

    override fun onCustomerPosition(myCustomerEntity: MyCustomerEntity) {
           val action=CustomerFragmentDirections.actionGlobalCustomerChatbotFragment(myCustomerEntity.name,myCustomerEntity.id)
           findNavController().navigate(action)
    }


}