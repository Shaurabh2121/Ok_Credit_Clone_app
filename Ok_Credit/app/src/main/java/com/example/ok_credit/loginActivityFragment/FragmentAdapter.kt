package com.example.ok_credit.loginActivityFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ok_credit.loginActivityFragment.VerifyFragment.ForthFragment
import com.example.ok_credit.loginActivityFragment.VerifyFragment.FristVeryfyFragment
import com.example.ok_credit.loginActivityFragment.VerifyFragment.SecondVeryfyFragment
import com.example.ok_credit.loginActivityFragment.VerifyFragment.ThridVeryfyFragment

class FragmentAdapter(fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
       return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 ->return FristVeryfyFragment()
            1 ->return SecondVeryfyFragment()
            2 ->return ThridVeryfyFragment()
            3 ->return ForthFragment()
        }
        return FristVeryfyFragment()
    }
}