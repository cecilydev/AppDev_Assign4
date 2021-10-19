package edu.temple.imageviewer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Array<ImageObj>? = null
    private var param2: String? = null

    private lateinit var items: Array<ImageObj>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            items = it.getParcelableArray(ARG_PARAM1) as Array<ImageObj>
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_selection, container, false)

        val recycle = layout.findViewById<RecyclerView>(R.id.recyclerView)

        recycle.layoutManager = GridLayoutManager(requireContext(), 3)

        recycle.adapter = ImageAdapter(items, { position -> onClickItem(position, items) })
        return layout

    }

    private fun onClickItem(position: Int, data: Array<ImageObj>) {

        val NPimage = data[position].resourceId
        val NPtext = data[position].description
        Log.d("NPimage", NPimage.toString());
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(items: Array<ImageObj>) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(ARG_PARAM1, items)
                    //putString(ARG_PARAM2, param2)
                }
            }
    }
}