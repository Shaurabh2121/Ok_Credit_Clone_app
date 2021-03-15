package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.ok_credit.BaseFragment
import com.example.ok_credit.R
import com.example.ok_credit.database.MVVM.MyAddSupplierViewModel
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierEntity
import com.example.ok_credit.database.MyAddSupplier.SupplierItemClickListener
import kotlinx.android.synthetic.main.fragment_supplier.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class SupplierFragment : BaseFragment(),SupplierItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_supplier, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        suplierRecyclerView.setHasFixedSize(true)
        suplierRecyclerView.layoutManager= LinearLayoutManager(context)


        val viewModel= ViewModelProviders.of(this).get(MyAddSupplierViewModel::class.java)
           launch {
               context?.let {
                   viewModel.getTask.observe(viewLifecycleOwner, Observer {

                   suplierRecyclerView.adapter=SupplierAdapter(it,this@SupplierFragment)
//                       recyclerView.adapter=NoteAdapter(it)

                   })
           }
    }

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addSupplierLinear.setOnClickListener {
            val action= SupplierFragmentDirections.actionGlobalAddSupplierFragment()
            findNavController().navigate(action)
        }
    }

    override fun onPosition(myAddSupplierEntity: MyAddSupplierEntity) {
      val action=SupplierFragmentDirections.actionGlobalSupllierChatbotFragment(myAddSupplierEntity.name,myAddSupplierEntity.id.toString())
       findNavController().navigate(action)
    }


}