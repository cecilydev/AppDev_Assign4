package edu.temple.imageviewer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectionActivity : AppCompatActivity() {

    val data = setData();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("National Parks")

        val recycle = findViewById<RecyclerView>(R.id.recyclerView)

        recycle.layoutManager = GridLayoutManager(this, 3)

        recycle.adapter = ImageAdapter(data, { position -> onClickItem(position) })

    }


    fun setData() : Array<ImageObj> {
        val images = arrayOf(ImageObj("Acadia", R.drawable.acadia), ImageObj("Badlands", R.drawable.badlands),
            ImageObj("Crater Lake", R.drawable.crater_lake),ImageObj("Denali", R.drawable.denali),
            ImageObj("Glacier", R.drawable.glacier),ImageObj("Grand Canyon", R.drawable.grand_canyon),
            ImageObj("Joshua Tree", R.drawable.joshua_tree),ImageObj("North Cascades", R.drawable.north_cascades),
            ImageObj("Redwoods", R.drawable.redwoods),ImageObj("Rocky Mountain", R.drawable.rocky_mountain),
            ImageObj("Yellowstone", R.drawable.yellowstone),ImageObj("Zion", R.drawable.zion)
        )

        return images
    }


    private fun onClickItem(position: Int) {

        val NPimage = data[position].resourceId
        val NPtext = data[position].description
        Log.d("NPimage", NPimage.toString());

        val intent = Intent(this@SelectionActivity, DisplayActivity::class.java)
        intent.putExtra("NPimage", NPimage)
        intent.putExtra("NPtext", NPtext)
        startActivity(intent)

    }
}