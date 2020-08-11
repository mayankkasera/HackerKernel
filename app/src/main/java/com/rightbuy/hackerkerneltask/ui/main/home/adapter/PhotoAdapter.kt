package com.rightbuy.hackerkerneltask.ui.main.home.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rightbuy.hackerkerneltask.R
import com.rightbuy.hackerkerneltask.network.pojo.PhotoRespose
import com.rightbuy.hackerkerneltask.ui.zoom.ZoomImageActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.photo.view.*

class PhotoAdapter (val context: Context, var list : List<PhotoRespose>) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.image
        val text = itemView.text
        val main = itemView.main

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(context).inflate(R.layout.photo, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        Picasso.get().load(list[position].thumbnailUrl).into(holder.image)
        holder.text.text = list.get(position).title
        holder.main.setOnClickListener {
            var intent = Intent(context,ZoomImageActivity::class.java)
            intent.putExtra("url",list[position].url)
            context.startActivity(intent)
        }
    }
}