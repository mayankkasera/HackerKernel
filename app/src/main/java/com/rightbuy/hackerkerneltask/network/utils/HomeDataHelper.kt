package com.rightbuy.hackerkerneltask.network.utils

import com.rightbuy.hackerkerneltask.network.photo.PhotoRepositoryI
import com.rightbuy.hackerkerneltask.utils.App
import javax.inject.Inject

class HomeDataHelper {

    init {
        App.networkHomeComponent()?.inject(this)
    }

    @Inject
    lateinit var photoRepositoryI : PhotoRepositoryI

}