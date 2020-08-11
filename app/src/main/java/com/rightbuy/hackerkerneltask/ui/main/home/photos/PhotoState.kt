package com.rightbuy.hackerkerneltask.ui.main.home.photos

import com.rightbuy.hackerkerneltask.network.pojo.PhotoRespose

sealed class PhotoState{
    data class Succes(var data : List<PhotoRespose>) : PhotoState()
    data class Failure(var message : String) : PhotoState()
}