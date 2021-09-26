package edu.temple.imageviewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import org.w3c.dom.Text

class ImageAdapter(_images: Array<ImageObj>): RecyclerView.Adapter<ImageAdapter.viewHolder>() {

    val images = _images

    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageNp: ImageView

        init{
            // Define click listener for the ViewHolder's View.
            imageNp = view.findViewById<ImageView>(R.id.imageView)
        }

    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: viewHolder, position: Int) {
        viewHolder.imageNp.setImageResource(images[position].resourceId)

    }



}