package com.rightbuy.hackerkerneltask.ui.main.home.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rightbuy.hackerkerneltask.network.api.post.PostRepositoryI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PostViewModel(var postRepositoryI: PostRepositoryI): ViewModel() {

    private var compositeDisposable = CompositeDisposable()
    val mutableLiveData: MutableLiveData<PostState> = MutableLiveData()

    fun getPost(){
        compositeDisposable.add(
            postRepositoryI.getPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableLiveData.postValue(PostState.AllPostSucces(it))
                },{
                    mutableLiveData.postValue(PostState.Failure(it.message!!))
                },{

                },{

                }))
    }

    fun getPostById(id:String){
        compositeDisposable.add(
            postRepositoryI.getPostById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableLiveData.postValue(PostState.PostSucces(it))
                },{
                    mutableLiveData.postValue(PostState.Failure(it.message!!))
                },{

                },{

                }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}