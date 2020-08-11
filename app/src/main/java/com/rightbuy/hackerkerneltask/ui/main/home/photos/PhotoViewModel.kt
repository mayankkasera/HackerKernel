package com.rightbuy.hackerkerneltask.ui.main.home.photos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rightbuy.hackerkerneltask.network.api.photo.PhotoRepositoryI
import com.rightbuy.hackerkerneltask.ui.authentication.AuthenticationState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PhotoViewModel(var photoRepositoryI : PhotoRepositoryI): ViewModel() {

    private var compositeDisposable = CompositeDisposable()
    val mutableLiveData: MutableLiveData<PhotoState> = MutableLiveData()

    fun getPhoto(){
        compositeDisposable.add(
            photoRepositoryI.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableLiveData.postValue(PhotoState.Succes(it))
                },{
                    mutableLiveData.postValue(PhotoState.Failure(it.message!!))
                },{

                },{

                }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}