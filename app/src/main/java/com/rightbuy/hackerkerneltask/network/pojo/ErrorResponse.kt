package com.rightbuy.hackerkerneltask.network.pojo


import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("errors")
    var errors: Errors = Errors(),
    @SerializedName("errors_keys")
    var errorsKeys: List<String> = listOf()
) {
    data class Errors(
        @SerializedName("message")
        var message: List<String> = listOf(),
        @SerializedName("email")
        var email: List<String> = listOf()
    )
}