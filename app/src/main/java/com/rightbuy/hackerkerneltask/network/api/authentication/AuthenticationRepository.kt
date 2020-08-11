package com.rightbuy.hackerkerneltask.network.api.authentication


import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationResponse
import com.rightbuy.hackerkerneltask.network.utils.CustomError
import com.rightbuy.hackerkerneltask.network.utils.NetworkHelper
import io.reactivex.Observable


class AuthenticationRepository(var authenticationRequests: AuthenticationRequests) :
    AuthenticationRepositoryI {
    override fun getRomanticComedy(networkHelper : NetworkHelper<AuthenticationResponse>,authenticationBody: AuthenticationBody): Observable<AuthenticationResponse> {
        return Observable.create<AuthenticationResponse> { emitter ->

            networkHelper.postRequest(authenticationRequests.signIn(authenticationBody),object :NetworkHelper.Callback<AuthenticationResponse>{
                override fun onResponce(responce: AuthenticationResponse) {
                    emitter.onNext(responce)
                    emitter.onComplete()
                }

                override fun onError(responce: String?) {
                    emitter.onError(CustomError(responce!!))
                }

                override fun onFailed(responce: String?) {
                    emitter.onError(CustomError(responce!!))
                }

            })
        }
    }

}