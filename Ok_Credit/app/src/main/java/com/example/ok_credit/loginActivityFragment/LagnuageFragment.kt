package com.example.ok_credit.loginActivityFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ok_credit.R
import kotlinx.android.synthetic.main.fragment_lagnuage.*


class LagnuageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lagnuage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
//      english.setOnClickListener(this)
//      hindi.setOnClickListener(this)
//      marathi.setOnClickListener(this)
//      hinglish.setOnClickListener(this)
//      gujrati.setOnClickListener(this)
//      tamil.setOnClickListener(this)
//      telgu.setOnClickListener(this)
//      punjabi.setOnClickListener(this)
//      malayalum.setOnClickListener(this)
//      kannad.setOnClickListener(this)
//      simpleCheckedTextView.setOnClickListener(this)


//        val simpleCheckedTextView =
//           view.findViewById(R.id.simpleCheckedTextView) as CheckedTextView // initiate a CheckedTextView
             simpleCheckedTextView.setOnClickListener {
                 simpleCheckedTextView.toggle()
//                 if (simpleCheckedTextView.isChecked){
//                     Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//                 }else{
//                     Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//                 }
             }
        english.setOnClickListener {
            english.toggle()
//            if (english.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        hindi.setOnClickListener {
            hindi.toggle()
//            if (hindi.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        marathi.setOnClickListener {
            marathi.toggle()
//            if (marathi.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }

        gujrati.setOnClickListener {
            gujrati.toggle()
//            if (gujrati.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        tamil.setOnClickListener {
            tamil.toggle()
//            if (tamil.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        kannad.setOnClickListener {
            kannad.toggle()
//            if (kannad.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        telgu.setOnClickListener {
            telgu.toggle()
//            if (telgu.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        malayalum.setOnClickListener {
            malayalum.toggle()
//            if (malayalum.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        punjabi.setOnClickListener {
            punjabi.toggle()
//            if (punjabi.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        hinglish.setOnClickListener {
            hinglish.toggle()
//            if (hinglish.isChecked){
//                Toast.makeText(context,"Checked",Toast.LENGTH_LONG).show()
//            }else{
//                Toast.makeText(context,"Not checked",Toast.LENGTH_LONG).show()
//            }
        }
        tvNext.setOnClickListener {
  val action = LagnuageFragmentDirections.actionLagnuageFragmentToVerifyMobileFragment()
            navController.navigate(action)
        }

    }

//    override fun onClick(v: View?) {
//        var id: Int? = v?.id
//
//        when(id){
//            0-> english.toggle()
//            1-> hindi.toggle()
//            2-> marathi.toggle()
//            3-> hinglish.toggle()
//            4-> gujrati.toggle()
//            5-> tamil.toggle()
//            6-> telgu.toggle()
//            7-> punjabi.toggle()
//            8-> malayalum.toggle()
//            9-> kannad.toggle()
//            10-> simpleCheckedTextView.toggle()
//        }
//
//    }


}


