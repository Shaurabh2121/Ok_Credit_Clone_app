package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ok_credit.R
import kotlinx.android.synthetic.main.customer_item_layout.*
import kotlinx.android.synthetic.main.fragment_customer_chatbot.*
import kotlinx.android.synthetic.main.fragment_supllier_chatbot.*
import kotlinx.coroutines.*

class CustomerChatbotFragment : Fragment() {
    var chatList = mutableListOf<ChatCustomerModel>()
    private lateinit var adapter: CustomerChatbotAdapter

    private val args:CustomerChatbotFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_chatbot, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val name=args.name
        val id=args.id
//        customerChatbot.text=name
        recyclerView()


        clickEvents()


        btn_received.setOnClickListener {
            paymentSms()
        }

    }

    private fun clickEvents() {
        btn_send.setOnClickListener {
            creditSms()
        }

        et_send.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages1.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun creditSms() {
        val message = et_send.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            chatList.add(ChatCustomerModel(message, ConstantCustomer.SEND_ID_CUS, timeStamp))
            et_send.setText("")


//            launch {
//                context?.let {sk ->
//                    val data= MyDatabase.getDatabase(sk).getSupplierChatDao()
//                         data.insert(SuppllierChatEnity(message, SEND_ID,timeStamp))
//                        data.getData()[0].
////                            chatList.clear()
////                            chatList.addAll(it)
//                adapter.insertMessage(data.getData())


            adapter.insertMessage(ChatCustomerModel(message, ConstantCustomer.SEND_ID_CUS, timeStamp))

            rv_messages1.scrollToPosition(adapter.itemCount - 1)


        }
    }

    private fun paymentSms() {
        val response = et_received.text.toString()
        val timeStamp = Time.timeStamp()
        if (response.isNotEmpty()) {
            //Adds it to our local list
            GlobalScope.launch {
                //Fake response delay
                delay(100)

                withContext(Dispatchers.Main) {
                    chatList.add(ChatCustomerModel(response, ConstantCustomer.RECEIVE_ID_CUS, timeStamp))
                    et_received.setText("")

                    //Inserts our message into the adapter
                    adapter.insertMessage(ChatCustomerModel(response, ConstantCustomer.RECEIVE_ID_CUS, timeStamp))

                    //Scrolls us to the position of the latest message

                    rv_messages1.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }
    private fun recyclerView() {
        adapter = CustomerChatbotAdapter()
        rv_messages1.adapter = adapter
        rv_messages1.layoutManager = LinearLayoutManager(context)

    }

    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages1.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
    }


