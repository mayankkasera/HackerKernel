package com.rightbuy.hackerkerneltask.ui.authentication

import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse

sealed class AuthenticationState {
    data class Succes(var data : AuthenticationResponse.Data) : AuthenticationState()
    data class Failure(var message : String) : AuthenticationState()
}