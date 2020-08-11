package com.rightbuy.hackerkerneltask.network.authentication

import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import io.reactivex.Observable

interface AuthenticationRepositoryI {
    fun getRomanticComedy(authenticationBody : AuthenticationBody) : Observable<AuthenticationResponse>
}