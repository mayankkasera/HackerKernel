package com.rightbuy.hackerkerneltask.network.utils


import com.rightbuy.hackerkerneltask.utils.App
import javax.inject.Inject

class DataHelper {

    init {
        App.networkComponent()?.inject(this)
    }



}