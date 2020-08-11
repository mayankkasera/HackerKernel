package com.rightbuy.hackerkerneltask.utils

import android.app.Application
import com.example.task_diagnal_technologies.di.component.DaggerAuthenticationNetworkComponent
import com.example.task_diagnal_technologies.di.component.AuthenticationNetworkComponent
import com.example.task_diagnal_technologies.di.component.DaggerHomeNetworkComponent
import com.example.task_diagnal_technologies.di.component.HomeNetworkComponent
import com.fxn.stash.Stash

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Stash.init(this);
        networkAuthenticationComponent = DaggerAuthenticationNetworkComponent.factory().create(Constants.baseUrl,this)
        homeNetworkComponent = DaggerHomeNetworkComponent.factory().create(Constants.baseUrlHome,this)
    }

    companion object {

        private var networkAuthenticationComponent : AuthenticationNetworkComponent? = null
        private var homeNetworkComponent : HomeNetworkComponent? = null

        fun networkAuthenticationComponent(): AuthenticationNetworkComponent? {
            return networkAuthenticationComponent
        }

        fun networkHomeComponent(): HomeNetworkComponent? {
            return homeNetworkComponent
        }




    }
}