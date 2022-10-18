package com.example.demo_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kotlinx.android.synthetic.main.item.view.*

class PhotoListAdapter : ListAdapter<Photo, PhotoViewHolder>(DiffCallback()) {
    var onItemClick : (Photo, Int) -> Unit = { _, _ -> }
    var onItemClickDelete : (List<Photo>, Int) -> Unit = { _ , _ -> }
    var onItemClickAdd : (List<Photo>, Int) -> Unit = {_, _ -> }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent ,false)
        return PhotoViewHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.binData(getItem(position))
        deleteItem(holder)
        addItem(holder)

        holder.itemView.setOnLongClickListener {
            it.buttonAddItem.visibility = View.VISIBLE
            it.buttonDelete.visibility = View.VISIBLE
            true
        }
    }

    private fun addItem(holder: PhotoViewHolder) {
        holder.itemView.buttonAddItem.setOnClickListener {
            onItemClickAdd(currentList, holder.adapterPosition + 1)
        }
    }

    private fun deleteItem(holder: PhotoViewHolder) {
        holder.itemView.buttonDelete.setOnClickListener {
            onItemClickDelete(currentList, holder.layoutPosition)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem?.id == newItem?.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }


}