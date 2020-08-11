package com.rightbuy.hackerkerneltask.network.api.post

import android.util.Log
import com.rightbuy.hackerkerneltask.network.pojo.PostResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepository(var postRequests : PostRequests):
    PostRepositoryI  {
    override fun getPost(): Observable<List<PostResponse>> {
        return Observable.create<List<PostResponse>> { emitter ->
            postRequests.getPosts().enqueue(object : Callback<List<PostResponse>> {
                override fun onFailure(call: Call<List<PostResponse>>, t: Throwable) {
                    emitter.onError(t)
                }

                override fun onResponse(
                    call: Call<List<PostResponse>>,
                    response: Response<List<PostResponse>>
                ) {
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

    override fun getPostById(id: String): Observable<PostResponse> {
        return Observable.create<PostResponse> { emitter ->

            postRequests.getPostById(id)
                .enqueue(object : Callback<PostResponse>{
                    override fun onFailure(call: Call<PostResponse>, t: Throwable) {
                        emitter.onError(t)
                    }

                    override fun onResponse(
                        call: Call<PostResponse>,
                        response: Response<PostResponse>
                    ) {
                        response.body()?.let {
                            emitter.onNext(it)
                            emitter.onComplete()
                        } ?: run {
                            emitter.onNext(PostResponse())
                            emitter.onComplete()
                        }
                    }
                })

        }
    }
}