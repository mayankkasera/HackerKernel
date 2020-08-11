package com.example.task_diagnal_technologies.di.component

import android.content.Context
import com.rightbuy.hackerkerneltask.di.module.DataModule
import com.rightbuy.hackerkerneltask.network.utils.HomeDataHelper
import com.rightbuy.hackerkerneltask.network.utils.AuthenticationDataHelper
import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface AuthenticationNetworkComponent {

    fun inject(authenticationDataHelper: AuthenticationDataHelper)
    fun inject(homeDataHelper: HomeDataHelper)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance @Named("name") name: String, @BindsInstance @Named("appContext") context: Context): AuthenticationNetworkComponent
    }
}