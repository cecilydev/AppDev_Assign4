package edu.temple.imageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        setTitle("National Park - Up Close View")

        val intent = intent
        val nptext = intent.getStringExtra("NPtext")
        val npimage = intent.getIntExtra("NPimage", 0)


        findViewById<TextView>(R.id.NPtext).text = nptext
        findViewById<ImageView>(R.id.NPimage).setImageResource(npimage)


    }
}