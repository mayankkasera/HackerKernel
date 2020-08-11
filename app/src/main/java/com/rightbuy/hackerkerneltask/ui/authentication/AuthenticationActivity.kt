package com.rightbuy.hackerkerneltask.ui.authentication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import com.rightbuy.hackerkerneltask.network.utils.AuthenticationDataHelper
import com.rightbuy.hackerkerneltask.network.utils.NetworkHelper
import com.rightbuy.hackerkerneltask.utils.ValidationsUtils
import com.rightbuy.hackerkerneltask.utils.createFactory
import kotlinx.android.synthetic.main.activity_login.*

class AuthenticationActivity : AppCompatActivity() {

    lateinit var authenticationViewModel : AuthenticationViewModel
    lateinit var networkHelper : NetworkHelper<AuthenticationResponse>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        setObserver()

        login.setOnClickListener {
            if(validate()){
                login.isEnabled = false
                loader.visibility = View.VISIBLE
                authenticationViewModel.authenticat(networkHelper,AuthenticationBody(email.text.toString(),password.text.toString(),"a"))
            }
        }



    }

    private fun init() {
        networkHelper = NetworkHelper(this)
        val factory = AuthenticationViewModel(AuthenticationDataHelper().authenticationRepositoryI).createFactory()
        authenticationViewModel = ViewModelProvider(this, factory).get(AuthenticationViewModel::class.java)
    }

    private fun setObserver() {
        authenticationViewModel.mutableLiveData.observe(this, Observer {
            loader.visibility = View.GONE
            login.isEnabled = true
            when(it){
                is AuthenticationState.Succes -> {
                    Log.i("sdcbdj",it.toString())
                }
                is AuthenticationState.Failure -> {
                    Log.i("sdcbdj",it.message)
                }
            }
        })

    }

    private fun validate(): Boolean {
        if (ValidationsUtils.checkEmail(email) && ValidationsUtils.isValidEditTextInput(password)){
            if(password.text.toString().length<6){
               Toast.makeText(this,"The password must be at least 6 characters.",Toast.LENGTH_SHORT).show()
                return false
            }
            else
                return true
        }
        else
            return false


    }
}
