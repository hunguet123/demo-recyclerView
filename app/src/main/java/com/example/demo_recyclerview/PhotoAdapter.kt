package com.example.demo_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PhotoAdapter : RecyclerView.Adapter<PhotoViewHolder>() {
    var onItemClick: (Photo, Int) ->Unit = { _, _ ->}
    private val photos = mutableListOf<Photo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return PhotoViewHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binData(photos[position])
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun updateData(newPhotos: List<Photo>) {
        photos.clear()
        photos.addAll(newPhotos)
        notifyDataSetChanged()
    }
}