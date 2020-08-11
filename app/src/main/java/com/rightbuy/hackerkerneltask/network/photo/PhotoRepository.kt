package com.rightbuy.hackerkerneltask.network.photo

import android.util.Log

import com.rightbuy.hackerkerneltask.network.pojo.PhotoRespose

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoRepository (var photoRequests : PhotoRequests): PhotoRepositoryI {
    override fun getPhotos(): Observable<List<PhotoRespose>> {
        return Observable.create<List<PhotoRespose>> { emitter ->
            photoRequests.getPhotos().enqueue(object : Callback<List<PhotoRespose>> {
                override fun onFailure(call: Call<List<PhotoRespose>>, t: Throwable) {
                    Log.i("kdsjcn", "onFailure " + t.toString())
                    emitter.onError(t)
                }

                override fun onResponse(
                    call: Call<List<PhotoRespose>>,
                    response: Response<List<PhotoRespose>>
                ) {
                    Log.i("kdsjcn", "onResponse  body : " + response.body().toString())
                    Log.i("kdsjcn", "onResponse  : " + response.toString())
                    response.body()?.let {
                        emitter.onNext(it)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(listOf())
                        emitter.onComplete()
                    }
                }

            })
        }
    }
}