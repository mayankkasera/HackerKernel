package com.rightbuy.hackerkerneltask.ui.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.PostResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post.view.*

class PostAdapter (val context: Context, var list : List<PostResponse>,var onClickCallback : OnClickCallback) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.text
        val description = itemView.description
        val main = itemView.main
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(context).inflate(R.layout.post, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        holder.text.text = "Title : "+list.get(position).title
        holder.description.text = "Description : "+list.get(position).body
        holder.main.setOnClickListener {
            onClickCallback.onClick(list[position].id)
        }

    }

    interface OnClickCallback{
        fun onClick(id:Int)
    }
}