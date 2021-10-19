package edu.temple.imageviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

   // val data = setData();
   private lateinit var fragmentSelection: SelectionFragment
   private lateinit var fragmentDisplay: DisplayFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(R.string.selection_activity_name)
        val data = setData();
        fragmentSelection = SelectionFragment.newInstance(data)
        fragmentDisplay = DisplayFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentSelectionView, fragmentSelection)
            .add(R.id.fragmentDipslayView, fragmentDisplay)
            .commit()
    }


    fun setData() : Array<ImageObj> {
        val array: Array<String> = resources.getStringArray(R.array.NPs)
        val images = arrayOf(ImageObj(array[0], R.drawable.acadia), ImageObj(array[1], R.drawable.badlands),
            ImageObj(array[2], R.drawable.crater_lake),ImageObj(array[3], R.drawable.denali),
            ImageObj(array[4], R.drawable.glacier),ImageObj(array[5], R.drawable.grand_canyon),
            ImageObj(array[6], R.drawable.joshua_tree),ImageObj(array[7], R.drawable.north_cascades),
            ImageObj(array[8], R.drawable.redwoods),ImageObj(array[9], R.drawable.rocky_mountain),
            ImageObj(array[10], R.drawable.yellowstone),ImageObj(array[11], R.drawable.zion)
        )

        return images
    }


    /*private fun onClickItem(position: Int, data: Array<ImageObj>) {

        val NPimage = data[position].resourceId
        val NPtext = data[position].description
        Log.d("NPimage", NPimage.toString());

        val intent = Intent(this@MainActivity, DisplayActivity::class.java)
        intent.putExtra("NPimage", NPimage)
        intent.putExtra("NPtext", NPtext)
        startActivity(intent)

    }*/
}