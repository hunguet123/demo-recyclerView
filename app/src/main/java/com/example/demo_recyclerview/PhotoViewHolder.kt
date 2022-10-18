package com.example.demo_recyclerview

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class PhotoViewHolder(itemView: View,
                      onItemClick: (Photo, Int) -> Unit,
) : RecyclerView.ViewHolder(itemView) {
    private var itemData: Photo? = null

    init {
        itemView.setOnClickListener {
            itemData?.let {
                onItemClick(it, adapterPosition)
            }
        }

    }

    fun binData(photo: Photo) {
        itemData = photo
        itemView.run {
            textViewName.text = photo.title
            Glide.with(context).load(photo.url).into(imgAvatar)
        }
    }

}