package com.rightbuy.hackerkerneltask.utils

import android.app.Application
import com.example.task_diagnal_technologies.di.component.DaggerNetworkComponent
import com.example.task_diagnal_technologies.di.component.NetworkComponent
import com.fxn.stash.Stash

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Stash.init(this);
        networkComponent = DaggerNetworkComponent.factory().create(Constants.baseUrl,this)
    }

    companion object {

        private var networkComponent : NetworkComponent? = null

        fun networkComponent(): NetworkComponent? {
            return networkComponent
        }
    }
}