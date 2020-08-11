package com.rightbuy.hackerkerneltask.network.photo

import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import com.rightbuy.hackerkerneltask.network.pojo.PhotoRespose
import io.reactivex.Observable
import retrofit2.Call

interface PhotoRepositoryI {
    fun getPhotos(): Observable<List<PhotoRespose>>
}