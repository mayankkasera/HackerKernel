package com.rightbuy.hackerkerneltask.network.utils

import java.io.IOException

class CustomError(var string: String): IOException() {
    override val message: String
        get() = string
}