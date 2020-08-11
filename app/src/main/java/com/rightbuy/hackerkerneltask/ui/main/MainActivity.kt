package com.rightbuy.hackerkerneltask.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.fxn.stash.Stash
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import com.rightbuy.hackerkerneltask.ui.authentication.AuthenticationActivity
import com.rightbuy.hackerkerneltask.ui.main.dashboard.DashBoardFragment
import com.rightbuy.hackerkerneltask.ui.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {

    private lateinit var  toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        setUpDrawer();
        replace(HomeFragment())
    }

    private fun setUpDrawer() {
        toogle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toogle)
        toogle.syncState()

        val headerLayout: View = navigation.getHeaderView(0)
        var email = headerLayout.findViewById(R.id.email) as TextView;
        var name = headerLayout.findViewById(R.id.name) as TextView;

        val status = Stash.getBoolean("loginStatus");

        if(status){
            email.text = Stash.getString("email")
            name.text = Stash.getString("name")
        }
        else{
           Log.i("sdjkbvcsk","snmdbms ")
        }




        navigation.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home ->{
                    replace(HomeFragment())
                }
                R.id.dashboard ->{
                    replace(DashBoardFragment())
                }
                R.id.logout -> {
                    Stash.clearAll()
                    startActivity(Intent(this, AuthenticationActivity::class.java))
                    finish()
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }


        menu.setOnClickListener {
            menuClick()
        }
    }

    fun replace(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame, fragment!!)
        ft.commit()
    }

    fun replace(
        fragment: Fragment,
        backstack: String
    ) {
        val ft = supportFragmentManager.beginTransaction()
        ft.addToBackStack(backstack)
        ft.add(R.id.frame, fragment, backstack)
        ft.commit()
    }

    private fun menuClick() {
        try {
            val inputManager = this@MainActivity
                .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                this@MainActivity.getCurrentFocus()!!.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        } catch (e: Exception) {
        }
        if (drawer.isDrawerVisible(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            drawer.openDrawer(GravityCompat.START)
        }
    }
}
