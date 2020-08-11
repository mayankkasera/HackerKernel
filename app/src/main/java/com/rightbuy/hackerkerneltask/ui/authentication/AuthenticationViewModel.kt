package com.rightbuy.hackerkerneltask.ui.authentication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rightbuy.hackerkerneltask.network.authentication.AuthenticationRepositoryI
import com.rightbuy.hackerkerneltask.network.pojo.AuthenticationBody
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AuthenticationViewModel(var authenticationRepositoryI : AuthenticationRepositoryI) : ViewModel() {

    private var compositeDisposable = CompositeDisposable()
    public val mutableLiveData: MutableLiveData<AuthenticationState> = MutableLiveData()

    fun authenticat(authenticationBody : AuthenticationBody) {
        compositeDisposable.add(
            authenticationRepositoryI.getRomanticComedy(authenticationBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableLiveData.postValue(AuthenticationState.Succes(it.data))
                },{
                    mutableLiveData.postValue(AuthenticationState.Failure(it.message!!))
                },{

                },{

                }))

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}