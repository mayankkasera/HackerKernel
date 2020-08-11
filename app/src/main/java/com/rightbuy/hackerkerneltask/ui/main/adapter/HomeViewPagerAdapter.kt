package com.rightbuy.hackerkerneltask.ui.main.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.rightbuy.hackerkerneltask.ui.main.dashboard.DashBoardFragment
import com.rightbuy.hackerkerneltask.ui.main.home.photos.PhotoFragment
import com.rightbuy.hackerkerneltask.ui.main.home.post.PostFragment

class HomeViewPagerAdapter(fm : FragmentManager)  : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
         if(position==0)
             return PhotoFragment()
         else
             return PostFragment()
    }

    override fun getCount(): Int {
         return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if(position==0)
            return "Photo"
        else
            return "Post"
    }
}