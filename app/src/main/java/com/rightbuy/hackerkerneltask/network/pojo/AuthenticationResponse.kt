package com.rightbuy.hackerkerneltask.network.pojo


import com.google.gson.annotations.SerializedName

data class AuthenticationResponse(
    @SerializedName("data")
    var `data`: Data = Data(),
    @SerializedName("message")
    var message: String = "",
    @SerializedName("return")
    var returnX: Boolean = false
) {
    data class Data(
        @SerializedName("api_token")
        var apiToken: String = "",
        @SerializedName("created_at")
        var createdAt: String = "",
        @SerializedName("deleted_at")
        var deletedAt: Any = Any(),
        @SerializedName("email")
        var email: String = "",
        @SerializedName("email_verified_at")
        var emailVerifiedAt: Any = Any(),
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("mobile")
        var mobile: String = "",
        @SerializedName("name")
        var name: String = "",
        @SerializedName("outlets")
        var outlets: Any = Any(),
        @SerializedName("sales_type")
        var salesType: Any = Any(),
        @SerializedName("time")
        var time: String = "",
        @SerializedName("updated_at")
        var updatedAt: String = "",
        @SerializedName("user_type")
        var userType: String = "",
        @SerializedName("wapicash_transfer")
        var wapicashTransfer: Any = Any()
    )
}