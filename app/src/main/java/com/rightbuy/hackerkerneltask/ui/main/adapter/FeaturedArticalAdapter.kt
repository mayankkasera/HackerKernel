package com.rightbuy.hackerkerneltask.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.AllArtical

class FeaturedArticalAdapter(
    private val context: Context,
    list: List<AllArtical>
) :
    RecyclerView.Adapter<FeaturedArticalAdapter.FeaturedArticalViewHolder>() {
    private val list: List<AllArtical>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FeaturedArticalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View =
            inflater.inflate(R.layout.featured_artical_item, parent, false)
        return FeaturedArticalViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FeaturedArticalViewHolder,
        position: Int
    ) {
        holder.title.setText(list[position].title)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FeaturedArticalViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var description: TextView

        init {
            title = itemView.findViewById(R.id.title)
            description = itemView.findViewById(R.id.description)
        }
    }

    init {
        this.list = list
    }
}
