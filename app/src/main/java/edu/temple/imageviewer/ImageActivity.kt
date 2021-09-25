package edu.temple.imageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycle = findViewById<RecyclerView>(R.id.recyclerView)

        recycle.layoutManager = GridLayoutManager(this, 3, RecyclerView.HORIZONTAL, false)

    }


    fun setData() : Array<ImageObj> {
        val images = arrayOf(ImageObj("Acadia National Park", R.drawable.acadia), ImageObj("Badlands National Park", R.drawable.badlands),
            ImageObj("Crater Lake National Park", R.drawable.crater_lake),ImageObj("Denali National Park", R.drawable.denali),
            ImageObj("Glacier National Park", R.drawable.glacier),ImageObj("Grand Canyon National Park", R.drawable.grand_canyon),
            ImageObj("Joshua Tree National Park", R.drawable.joshua_tree),ImageObj("North Cascades National Park", R.drawable.north_cascades),
            ImageObj("Redwoods National Park", R.drawable.redwoods),ImageObj("Rocky Mountain National Park", R.drawable.rocky_mountain),
            ImageObj("Yellowstone National Park", R.drawable.yellowstone),ImageObj("Zion National Park", R.drawable.zion)
        )

        return images
    }
}