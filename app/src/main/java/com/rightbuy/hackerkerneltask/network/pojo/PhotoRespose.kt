package com.rightbuy.hackerkerneltask.network.pojo


import com.google.gson.annotations.SerializedName

data class PhotoRespose(
    @SerializedName("albumId")
    var albumId: Int = 0,
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String = "",
    @SerializedName("title")
    var title: String = "",
    @SerializedName("url")
    var url: String = ""
)