package com.rightbuy.hackerkerneltask.ui.main.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.AllArtical
import com.rightbuy.hackerkerneltask.ui.main.adapter.FeaturedArticalAdapter
import com.rightbuy.hackerkerneltask.ui.main.adapter.FeaturedVideosAdapter
import kotlinx.android.synthetic.main.fragment_dash_board.view.*
import java.util.*


class DashBoardFragment : Fragment() {

    lateinit var mView : View
    private val list: ArrayList<AllArtical> = ArrayList<AllArtical>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_dash_board, container, false)


        val layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        mView.homeartical_recycler.layoutManager = layoutManager

        val videolayoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        mView.videoartical_recycler.layoutManager = videolayoutManager

        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))
        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))
        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))
        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))
        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))
        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))
        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))
        list.add(AllArtical("", "Much up your way", "msdjbbsdj"))

        val adapter = FeaturedArticalAdapter(activity!!, list)
        mView.homeartical_recycler.adapter = adapter

        val videoadapter = FeaturedVideosAdapter(activity!!, list)
        mView.videoartical_recycler.adapter = videoadapter


        return mView
    }


}
