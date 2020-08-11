package com.rightbuy.hackerkerneltask.ui.main

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.ui.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {

    private lateinit var  toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        toogle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toogle)
        toogle.syncState()


        menu.setOnClickListener {
            menuClick()
        }

        replace(HomeFragment())
    }

    fun replace(fragment: Fragment) {
        val ft =
            supportFragmentManager.beginTransaction()
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
