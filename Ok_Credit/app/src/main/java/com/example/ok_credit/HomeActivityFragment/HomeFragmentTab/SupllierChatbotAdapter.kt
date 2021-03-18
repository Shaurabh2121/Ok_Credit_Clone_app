package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ok_credit.HomeActivityFragment.HomeFragmentTab.Constants.RECEIVE_ID
import com.example.ok_credit.HomeActivityFragment.HomeFragmentTab.Constants.SEND_ID
import com.example.ok_credit.R
import com.example.ok_credit.database.SupplierChatBot.SuppllierChatEnity
import kotlinx.android.synthetic.main.message_item_supplier.view.*

class SupllierChatbotAdapter():RecyclerView.Adapter<SupllierChatbotAdapter.SupllierChatbotHolder>() {
     var chatList= mutableListOf<ChatBotModel>()



    inner class SupllierChatbotHolder(val view: View):RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener {

                //Remove message on the item clicked
                chatList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupllierChatbotHolder {
        return SupllierChatbotHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.message_item_supplier, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SupllierChatbotHolder, position: Int) {
        val currentMessage = chatList[position]

        when (currentMessage.id) {
            SEND_ID -> {
                holder.itemView.tv_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_2.visibility = View.GONE
                holder.itemView.tv_time1.apply {
                    text=currentMessage.time
                    visibility=View.VISIBLE
                }
                holder.itemView.ll_2.visibility=View.GONE
            }
            RECEIVE_ID -> {
                holder.itemView.tv_bot_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.ll_1.visibility = View.GONE
                holder.itemView.tv_time2.apply {
                    text=currentMessage.time
                    visibility=View.VISIBLE
                }
                holder.itemView.ll_1.visibility=View.GONE
            }
        }

    }

    override fun getItemCount(): Int {
      return chatList.size
    }
    fun insertMessage(chatBotModel: ChatBotModel) {
        this.chatList.add(chatBotModel)
        notifyItemInserted(chatList.size)
    }
}


