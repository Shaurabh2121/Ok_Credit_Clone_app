package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ok_credit.R
import com.example.ok_credit.database.MyAddCustomer.CustomerItemClickListener
import com.example.ok_credit.database.MyAddCustomer.MyCustomerEntity

class CustomerAdpter(val myCustomerEntityList: List<MyCustomerEntity>,val listener: CustomerItemClickListener): RecyclerView.Adapter<CustomerAdpter.CustomerViewHolder>() {

    inner class CustomerViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){
        val mname=itemView.findViewById<TextView>(R.id.tvCusName)
        val mPostion=itemView.findViewById<LinearLayout>(R.id.customerPostion)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        var view=
            LayoutInflater.from(parent.context).inflate(R.layout.customer_item_layout,parent,false)
        return CustomerViewHolder(view)
    }

    override fun onBindViewHolder(holder:CustomerViewHolder, position: Int) {
        holder.mname.text=myCustomerEntityList[position].name
        holder.mPostion.setOnClickListener {
            listener.onCustomerPosition(myCustomerEntityList[position])
        }
    }

    override fun getItemCount(): Int {
        return myCustomerEntityList.size
    }
}