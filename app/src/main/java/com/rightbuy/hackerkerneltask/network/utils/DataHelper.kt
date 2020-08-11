package com.rightbuy.hackerkerneltask.network.utils


import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRepositoryI
import com.rightbuy.hackerkerneltask.utils.App
import javax.inject.Inject

class DataHelper {

    init {
        App.networkComponent()?.inject(this)
    }

    @Inject
    lateinit var authenticationRepositoryI: AuthenticationRepositoryI

}