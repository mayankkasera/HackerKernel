package com.rightbuy.hackerkerneltask.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fxn.stash.Stash
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import com.rightbuy.hackerkerneltask.ui.authentication.AuthenticationActivity
import com.rightbuy.hackerkerneltask.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val status = Stash.getBoolean("loginStatus")

        if(!status)
            startActivity(Intent(this,AuthenticationActivity::class.java))
        else
            startActivity(Intent(this,MainActivity::class.java))

        finish()
    }
}
