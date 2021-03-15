package com.example.ok_credit.HomeActivityFragment.DrawerFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ok_credit.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth= FirebaseAuth.getInstance()

        signOut.setOnClickListener {
            auth.signOut()
            val action =SettingFragmentDirections.actionSettingFragmentToLoginActivity()
            findNavController().navigate(action)
        }

    }

}