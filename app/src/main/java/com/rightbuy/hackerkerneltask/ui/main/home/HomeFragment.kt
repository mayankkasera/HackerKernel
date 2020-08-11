package com.rightbuy.hackerkerneltask.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.ui.main.adapter.HomeViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var  mview:View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_home, container, false)

        mview.viewpager.adapter = HomeViewPagerAdapter(childFragmentManager)
        mview.tabLayout.setupWithViewPager(mview.viewpager)

        return mview

    }

}
