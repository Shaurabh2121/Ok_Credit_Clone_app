package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ok_credit.R
import com.example.ok_credit.database.MyAddSupplier.MyAddSupplierEntity
import com.example.ok_credit.database.MyAddSupplier.SupplierItemClickListener

class SupplierAdapter(val myAddSupplierEntityList: List<MyAddSupplierEntity>,val listener:SupplierItemClickListener):RecyclerView.Adapter<SupplierAdapter.SupplierViewHolder>() {

    inner class SupplierViewHolder(private val itemView: View):RecyclerView.ViewHolder(itemView){
        val mname=itemView.findViewById<TextView>(R.id.tvSupName)
        val mPostion =itemView.findViewById<LinearLayout>(R.id.suplierPostion)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplierViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.supplier_item_layout,parent,false)
        return SupplierViewHolder(view)
    }

    override fun onBindViewHolder(holder: SupplierViewHolder, position: Int) {
        holder.mname.text=myAddSupplierEntityList[position].name
        holder.mPostion.setOnClickListener {
            listener.onPosition(myAddSupplierEntityList[position])
        }
    }

    override fun getItemCount(): Int {
        return myAddSupplierEntityList.size
    }
}