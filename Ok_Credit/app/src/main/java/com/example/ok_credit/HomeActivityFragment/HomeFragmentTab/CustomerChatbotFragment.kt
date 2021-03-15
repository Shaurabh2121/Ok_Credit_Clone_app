package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.ok_credit.R
import kotlinx.android.synthetic.main.customer_item_layout.*
import kotlinx.android.synthetic.main.fragment_customer_chatbot.*

class CustomerChatbotFragment : Fragment() {
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
        customerChatbot.text=name
    }


}