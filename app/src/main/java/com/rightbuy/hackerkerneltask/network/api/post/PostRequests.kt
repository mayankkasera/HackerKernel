package com.rightbuy.hackerkerneltask.network.api.post

import com.rightbuy.hackerkerneltask.network.pojo.PhotoRespose
import com.rightbuy.hackerkerneltask.network.pojo.PostResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostRequests {
    @GET("posts")
    fun getPosts(): Call<List<PostResponse>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id : String): Call<PostResponse>
}