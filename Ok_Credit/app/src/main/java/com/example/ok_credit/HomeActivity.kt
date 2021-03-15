package com.example.ok_credit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(){
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
//    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//        auth= FirebaseAuth.getInstance()
      setSupportActionBar(toolbar)
        val naHostFragment=supportFragmentManager.findFragmentById(R.id.fragment2)as NavHostFragment
        navController=naHostFragment.navController
        appBarConfiguration= AppBarConfiguration(navController.graph,drawer_layout)
    NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration)
        nav_drawer.setupWithNavController(navController)



//        var currentUser=auth.currentUser
//        if(currentUser==null){
//            startActivity(Intent(this,LoginActivity::class.java))
//            finish()
//        }
//
//        btnLogOut.setOnClickListener{
//            auth.signOut()
//            startActivity(Intent(this,LoginActivity::class.java))
//            finish()
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
    }



//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return  item.onNavDestinationSelected(navController) ||super.onOptionsItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.search_menu,menu)
//        val search=menu?.findItem(R.id.menu_search)
//        val searchView=search?.actionView as SearchView
//        searchView.queryHint="Search something!"
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                return true
//            }
//        })
//        return super.onCreateOptionsMenu(menu)
//    }
}