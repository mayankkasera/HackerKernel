package com.rightbuy.hackerkerneltask.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.utils.DataHelper
import com.rightbuy.hackerkerneltask.utils.createFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AuthenticationActivity : AppCompatActivity() {

    lateinit var authenticationViewModel : AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        setObserver()




    }

    private fun init() {
        val factory = AuthenticationViewModel(DataHelper().authenticationRepositoryI).createFactory()
        authenticationViewModel = ViewModelProvider(this, factory).get(AuthenticationViewModel::class.java)
    }

    private fun setObserver() {
        authenticationViewModel.mutableLiveData.observe(this, Observer {
            when(it){
                is AuthenticationState.Succes -> {
                    Log.i("sdcbdj",it.toString())
                }
                is AuthenticationState.Failure -> {
                    Log.i("sdcbdj",it.message)
                    Toast.makeText(this,it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

    }
}
