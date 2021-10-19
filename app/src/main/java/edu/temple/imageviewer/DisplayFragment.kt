package edu.temple.imageviewer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class DisplayFragment : Fragment() {

    private lateinit var layout : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout =inflater.inflate(R.layout.fragment_display, container, false)

        ViewModelProvider(requireActivity())
            .get(NPViewModel::class.java)
            .selectedItem.observe(requireActivity(), {
                Log.d("NPdesc", it.description.toString());
                Log.d("NPID", it.resourceId.toString());
                layout.findViewById<TextView>(R.id.textNP).text=it.description.toString()
                layout.findViewById<ImageView>(R.id.imageNP).setImageResource(it.resourceId)
            })
        return layout
    }



}