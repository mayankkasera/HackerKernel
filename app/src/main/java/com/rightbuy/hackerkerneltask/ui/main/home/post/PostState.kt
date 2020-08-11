package com.rightbuy.hackerkerneltask.ui.main.home.post

import com.rightbuy.hackerkerneltask.network.pojo.PostResponse

sealed class PostState {
    data class AllPostSucces(var data : List<PostResponse>) : PostState()
    data class PostSucces(var data : PostResponse) : PostState()
    data class Failure(var message : String) : PostState()
}