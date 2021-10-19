package edu.temple.imageviewer

import android.os.Parcel
import android.os.Parcelable

data class ImageObj(val description: String?, val resourceId: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeInt(resourceId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImageObj> {
        override fun createFromParcel(parcel: Parcel): ImageObj {
            return ImageObj(parcel)
        }

        override fun newArray(size: Int): Array<ImageObj?> {
            return arrayOfNulls(size)
        }
    }
}
