package com.rightbuy.hackerkerneltask.network.authentication

import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import com.rightbuy.hackerkerneltask.network.utils.NetworkHelper
import io.reactivex.Observable

interface AuthenticationRepositoryI {
    fun getRomanticComedy(networkHelper : NetworkHelper<AuthenticationResponse>,authenticationBody : AuthenticationBody) : Observable<AuthenticationResponse>
}