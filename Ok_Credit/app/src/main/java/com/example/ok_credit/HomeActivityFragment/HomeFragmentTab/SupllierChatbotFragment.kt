package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ok_credit.BaseFragment
import com.example.ok_credit.HomeActivityFragment.HomeFragmentTab.Constants.RECEIVE_ID
import com.example.ok_credit.HomeActivityFragment.HomeFragmentTab.Constants.SEND_ID
import com.example.ok_credit.R
import com.example.ok_credit.database.MyDatabase
import com.example.ok_credit.database.SupplierChatBot.SuppllierChatEnity
import kotlinx.android.synthetic.main.fragment_supllier_chatbot.*
import kotlinx.coroutines.*


class SupllierChatbotFragment : BaseFragment() {
    var chatList = mutableListOf<ChatBotModel>()
    private lateinit var adapter: SupllierChatbotAdapter

    private val args: SupllierChatbotFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_supllier_chatbot, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var name = args.name
        var id=args.id

        recyclerView()


        clickEvents()


       btn_payment.setOnClickListener {
         paymentSms()
     }

    }

    private fun clickEvents() {
        btn_credit.setOnClickListener {
            creditSms()
        }

        et_credit_Amt.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun creditSms() {
        val message = et_credit_Amt.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            chatList.add(ChatBotModel(message, SEND_ID, timeStamp))
            et_credit_Amt.setText("")


//            launch {
//                context?.let {sk ->
//                    val data= MyDatabase.getDatabase(sk).getSupplierChatDao()
//                         data.insert(SuppllierChatEnity(message, SEND_ID,timeStamp))
//                        data.getData()[0].
////                            chatList.clear()
////                            chatList.addAll(it)
//                adapter.insertMessage(data.getData())


            adapter.insertMessage(ChatBotModel(message, SEND_ID, timeStamp))

            rv_messages.scrollToPosition(adapter.itemCount - 1)


        }
    }

    private fun paymentSms() {
        val response = et_pay_Amt.text.toString()
        val timeStamp = Time.timeStamp()
        if (response.isNotEmpty()) {
            //Adds it to our local list
            GlobalScope.launch {
                //Fake response delay
                delay(100)

                withContext(Dispatchers.Main) {
                    chatList.add(ChatBotModel(response, RECEIVE_ID, timeStamp))
                    et_pay_Amt.setText("")

                    //Inserts our message into the adapter
                    adapter.insertMessage(ChatBotModel(response, RECEIVE_ID, timeStamp))

                    //Scrolls us to the position of the latest message

                    rv_messages.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }
    private fun recyclerView() {
        adapter = SupllierChatbotAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(context)

    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}