package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ok_credit.R
import kotlinx.android.synthetic.main.customer_chat_item.view.*


class CustomerChatbotAdapter: RecyclerView.Adapter<CustomerChatbotAdapter.CustomerChatbotHolder>()  {
    var CuschatList= mutableListOf<ChatCustomerModel>()

    inner class CustomerChatbotHolder(val view: View): RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener {

                //Remove message on the item clicked
                CuschatList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerChatbotHolder {
        return CustomerChatbotHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.customer_chat_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomerChatbotHolder, position: Int) {
        val currentMessageCus = CuschatList[position]

        when (currentMessageCus.idCus) {
            ConstantCustomer.SEND_ID_CUS -> {
                holder.itemView.tv_messageCus.apply {
                    text = currentMessageCus.messageCus
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_2Cus.visibility = View.GONE
                holder.itemView.tv_time1Cus.apply {
                    text=currentMessageCus.timeCus
                    visibility= View.VISIBLE
                }
                holder.itemView.ll_2Cus.visibility= View.GONE
            }
            ConstantCustomer.RECEIVE_ID_CUS -> {
                holder.itemView.tv_bot_messageCus.apply {
                    text = currentMessageCus.messageCus
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_1cus.visibility = View.GONE
                holder.itemView.tv_time2Cus.apply {
                    text=currentMessageCus.timeCus
                    visibility= View.VISIBLE
                }
                holder.itemView.ll_1cus.visibility= View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
        return CuschatList.size
    }
    fun insertMessage(chatCustomerModel: ChatCustomerModel) {
        this.CuschatList.add(chatCustomerModel)
        notifyItemInserted(CuschatList.size)
    }
}