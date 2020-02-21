package com.example.kotlinpractice

import android.os.Parcel
import android.os.Parcelable

data class UserFavouriteModel(val image: Int, val name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserFavouriteModel> {
        override fun createFromParcel(parcel: Parcel): UserFavouriteModel {
            return UserFavouriteModel(parcel)
        }

        override fun newArray(size: Int): Array<UserFavouriteModel?> {
            return arrayOfNulls(size)
        }
    }


}