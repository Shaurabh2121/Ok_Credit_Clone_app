package com.example.ok_credit.HomeActivityFragment.HomeFragmentTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ok_credit.R
import kotlinx.android.synthetic.main.fragment_supllier_chatbot.*


class SupllierChatbotFragment : Fragment() {
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
        btn_payment.setOnClickListener {
            val action=SupplierFragmentDirections.actionGlobalPaymentSupplierFragment()
            findNavController().navigate(action)
        }

    }

}