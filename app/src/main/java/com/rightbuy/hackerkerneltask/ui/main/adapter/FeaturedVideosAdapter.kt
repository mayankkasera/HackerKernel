package com.rightbuy.hackerkerneltask.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.AllArtical
import kotlinx.android.synthetic.main.featured_artical_item.view.*

class FeaturedVideosAdapter(
    private val context: Context,
    val list: List<AllArtical>
) :
    RecyclerView.Adapter<FeaturedVideosAdapter.FeaturedVideoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeaturedVideoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.featured_video_item, parent, false)
        return FeaturedVideoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FeaturedVideoViewHolder,
        position: Int
    ) {
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FeaturedVideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var description = itemView.description
    }


}
