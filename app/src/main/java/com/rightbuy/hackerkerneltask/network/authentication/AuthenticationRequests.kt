package com.rightbuy.hackerkerneltask.network.authentication

import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationRequests {

    @POST("user-login")
    fun signIn(@Body authenticationBody : AuthenticationBody): Call<AuthenticationResponse>
}