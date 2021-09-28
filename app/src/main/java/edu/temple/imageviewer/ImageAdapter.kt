package edu.temple.imageviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(_images: Array<ImageObj>, val onClicked: (position: Int) -> Unit): RecyclerView.Adapter<ImageAdapter.viewHolder>() {
    val images = _images

    class viewHolder(view: View, val onClicked: (position: Int) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val imageNpItem: ImageView

        init{
            imageNpItem = view.findViewById<ImageView>(R.id.imageView)
            view.setOnClickListener (this)
        }

        override fun onClick(v: View) {
            val position = adapterPosition
            onClicked(position)
        }


    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return viewHolder(view, onClicked)
    }

    override fun onBindViewHolder(viewHolder: viewHolder, position: Int) {
        viewHolder.imageNpItem.setImageResource(images[position].resourceId)

    }



}