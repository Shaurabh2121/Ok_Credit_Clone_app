package com.example.ok_credit.loginActivityFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.ok_credit.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_verify_mobile.*


class VerifyMobileFragment : Fragment() {
private  var viewPager2: ViewPager2?=null
private  var tabLayout: TabLayout?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_mobile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        initView()
        setViewPagerAdapter()
        tvVerify.setOnClickListener {
            val action=VerifyMobileFragmentDirections.actionVerifyMobileFragmentToOTPMentionFragment()
            navController.navigate(action)
        }
    }

    private fun initView() {
        viewPager2 = view?.findViewById(R.id.viewPager)
        tabLayout=view?.findViewById(R.id.tabLayout)
    }

    private fun setViewPagerAdapter() {
     val fragmentAdapter=FragmentAdapter(context as FragmentActivity)
        viewPager2?.adapter =fragmentAdapter
        tabLayout?.let { viewPager2?.let { it1 ->
            TabLayoutMediator(it,
                it1, TabLayoutMediator.TabConfigurationStrategy { tab, position ->  }).attach()
        } }
    }


}