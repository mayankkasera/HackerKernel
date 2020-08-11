package com.rightbuy.hackerkerneltask.network.utils


import com.rightbuy.hackerkerneltask.network.api.authentication.AuthenticationRepositoryI
import com.rightbuy.hackerkerneltask.utils.App
import javax.inject.Inject

class AuthenticationDataHelper {

    init {
        App.networkAuthenticationComponent()?.inject(this)
    }

    @Inject
    lateinit var authenticationRepositoryI: AuthenticationRepositoryI

}