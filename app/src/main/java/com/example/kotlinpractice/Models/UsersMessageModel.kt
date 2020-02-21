package com.example.kotlinpractice

import android.os.Parcel
import android.os.Parcelable

data class UsersMessageModel(
    val image: Int,
    val name: String,
    val message: String,
    val day: String,
    val type: String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(message)
        parcel.writeString(day)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsersMessageModel> {
        override fun createFromParcel(parcel: Parcel): UsersMessageModel {
            return UsersMessageModel(parcel)
        }

        override fun newArray(size: Int): Array<UsersMessageModel?> {
            return arrayOfNulls(size)
        }
    }
}