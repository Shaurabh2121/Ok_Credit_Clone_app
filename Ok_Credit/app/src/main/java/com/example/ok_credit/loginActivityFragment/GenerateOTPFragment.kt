package com.example.ok_credit.loginActivityFragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ok_credit.HomeActivity
import com.example.ok_credit.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_generate_o_t_p.*


class GenerateOTPFragment : Fragment() {

    lateinit var auth: FirebaseAuth
    private val args: GenerateOTPFragmentArgs by navArgs()
    private var number:String?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generate_o_t_p, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val loadingDialog=LoadingDialog(this)
        var storedVerificationId = args.storedVerificationId
         number=args.number
        tvNum.text="Your OTP will be delivered soon on $number"
        verifyBtn.setOnClickListener {
            var otp = id_otp.text.toString().trim()
            if (!otp.isEmpty()) {
                val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp
                )
                signInWithPhoneAuthCredential(credential)
            } else {
                Toast.makeText(context, "Enter OTP", Toast.LENGTH_SHORT).show()
            }

            loadingDialog.startLoadingDialog()
            val handler= Handler()
            handler.postDelayed({
                loadingDialog.dismissDialog()
            },4000)


        }

    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val navController = findNavController()

                    val action = GenerateOTPFragmentDirections.actionGenerateOTPFragmentToBussinessNameFragment(number!!)
                             navController.navigate(action)
                } else {
//// Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
//// The verification code entered was invalid
                        Toast.makeText(context, "Invalid OTP", Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }
}


