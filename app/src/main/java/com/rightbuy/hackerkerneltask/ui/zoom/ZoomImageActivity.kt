package com.rightbuy.hackerkerneltask.ui.zoom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler
import com.rightbuy.hackerkerneltask.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_zoom_image.*


class ZoomImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_image)

        var url = intent.getStringExtra("url");


        Picasso.get().load(url).into(image)
        image.setOnTouchListener(ImageMatrixTouchHandler(image.getContext()))

    }
}
