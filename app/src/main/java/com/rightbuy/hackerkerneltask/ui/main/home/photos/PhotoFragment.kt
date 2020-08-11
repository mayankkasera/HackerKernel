package com.rightbuy.hackerkerneltask.ui.main.home.photos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.utils.HomeDataHelper
import com.rightbuy.hackerkerneltask.utils.createFactory
import kotlinx.android.synthetic.main.fragment_photo.*
import kotlinx.android.synthetic.main.fragment_photo.view.*

/**
 * A simple [Fragment] subclass.
 */
class PhotoFragment : Fragment() {

    lateinit var mView: View
    lateinit var photoViewModel: PhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_photo, container, false)


        init()
        setObserver()

        mView.loader.visibility = View.VISIBLE
        photoViewModel.getPhoto()


        return mView
    }

    private fun init() {
        val factory = PhotoViewModel(HomeDataHelper().photoRepositoryI).createFactory()
        photoViewModel = ViewModelProvider(this, factory).get(PhotoViewModel::class.java)
    }

    private fun setObserver() {
        photoViewModel.mutableLiveData.observe(this, Observer {
            loader.visibility = View.GONE
            when(it){
                is PhotoState.Succes -> {
                    Log.i("sdcbdj",it.toString())
                }
                is PhotoState.Failure -> {
                    Log.i("sdcbdj",it.message)
                }
            }
        })

    }


}
