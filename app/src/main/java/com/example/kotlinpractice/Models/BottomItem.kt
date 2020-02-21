package com.example.kotlinpractice

import android.os.Parcel
import android.os.Parcelable

class BottomItem {

    public var itemId: Int = 0
    public var itemIconId: Int = 0
    public var itemFillIconId: Int = 0
    public var isHasNotification = false

    constructor(itemId: Int, itemIconId: Int, itemFillIconId: Int, isHasNotification: Boolean) {
        this.itemId = itemId
        this.itemIconId = itemIconId
        this.itemFillIconId = itemFillIconId
        this.isHasNotification = isHasNotification

    }

}