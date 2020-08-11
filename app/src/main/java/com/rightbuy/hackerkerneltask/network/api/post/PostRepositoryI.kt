package com.rightbuy.hackerkerneltask.network.api.post

import com.rightbuy.hackerkerneltask.network.pojo.PostResponse
import io.reactivex.Observable


interface PostRepositoryI{
    fun getPost(): Observable<List<PostResponse>>

    fun getPostById(id:String): Observable<PostResponse>
}