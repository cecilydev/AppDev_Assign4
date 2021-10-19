package edu.temple.imageviewer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NPViewModel : ViewModel() {
    private val nPark = MutableLiveData<ImageObj>()

    val selectedItem: LiveData<ImageObj> get() = nPark

    fun selectItem(item: ImageObj) {
        nPark.value = item
    }

}