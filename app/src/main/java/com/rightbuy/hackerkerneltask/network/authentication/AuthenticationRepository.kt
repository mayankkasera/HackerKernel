package com.rightbuy.hackerkerneltask.network.authentication

import android.util.Log
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthenticationRepository(var authenticationRequests: AuthenticationRequests) : AuthenticationRepositoryI {
    override fun getRomanticComedy(authenticationBody: AuthenticationBody): Observable<AuthenticationResponse> {
        return Observable.create<AuthenticationResponse> { emitter ->
            authenticationRequests.signIn(authenticationBody).enqueue(object :
                Callback<AuthenticationResponse> {
                override fun onResponse(call: Call<AuthenticationResponse>, response: Response<AuthenticationResponse>) {
                    Log.i("kdsjcn", "onResponse  body : " + response.body().toString())
                    Log.i("kdsjcn", "onResponse  : " + response.toString())
                    response.body()?.let {
                        emitter.onNext(it)
                        emitter.onComplete()
                    } ?: run {
                        emitter.onNext(AuthenticationResponse())
                        emitter.onComplete()
                    }
                }

                override fun onFailure(call: Call<AuthenticationResponse>, t: Throwable) {
                    Log.i("kdsjcn", "onFailure " + t.toString())
                    emitter.onError(t)
                }
            })
        }
    }
}