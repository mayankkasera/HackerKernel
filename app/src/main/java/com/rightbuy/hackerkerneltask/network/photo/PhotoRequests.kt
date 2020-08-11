package com.rightbuy.hackerkerneltask.network.photo

import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import com.rightbuy.hackerkerneltask.network.pojo.PhotoRespose
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PhotoRequests {

    @GET("photos")
    fun getPhotos(): Call<List<PhotoRespose>>

}