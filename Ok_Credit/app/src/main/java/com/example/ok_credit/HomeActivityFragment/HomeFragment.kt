package com.example.ok_credit.HomeActivityFragment

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController

import androidx.viewpager2.widget.ViewPager2
import com.example.ok_credit.HomeActivityFragment.HomeFragmentTab.HomePagerAdapter
import com.example.ok_credit.R
import com.google.android.material.tabs.TabLayout

import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    lateinit var navController: NavController

    private  var viewPager: ViewPager2?=null
    private  var tabLayout: TabLayout?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setViewPagerAdapter()
    }

    private fun initView() {

        viewPager = view?.findViewById(R.id.vPager1)
        tabLayout=view?.findViewById(R.id.tabLayout1)
    }

    private fun setViewPagerAdapter() {


        val homePagerAdapter= HomePagerAdapter(context as FragmentActivity)
        viewPager?.adapter =homePagerAdapter
        tabLayout?.let { viewPager?.let { it1 ->
            TabLayoutMediator(it,
                it1, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0->tab.text="CUSTOMER"
                    1->tab.text="SUPPLIER"

                }
            }).attach()
        } }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return  super.onOptionsItemSelected(item)
//
//    }
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.search_menu,menu)
//        val search= menu.findItem(R.id.menu_search)
//        val searchView=search?.actionView as SearchView
//        searchView.queryHint="Search something!"
//        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return true
//            }
//        })
//    }


}