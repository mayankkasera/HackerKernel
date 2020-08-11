package com.rightbuy.hackerkerneltask.network.pojo


import com.google.gson.annotations.SerializedName

data class AuthenticationBody(
    @SerializedName("email")
    var email: String = "",
    @SerializedName("password")
    var password: String = "",
    @SerializedName("type")
    var type: String = ""
)