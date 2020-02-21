package com.example.kotlinpractice

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class BottomBarAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Parcelable {

    private lateinit var bottomItems: ArrayList<BottomItem>
    private var itemWidth: Int = 0
    private var selected: Int = 0
    private lateinit var bottomItemClickInterface: BottomItemClickInterface

    constructor(parcel: Parcel) : this() {
        selected = parcel.readInt()
    }

    constructor(
        selected: Int,
        bottomItems: ArrayList<BottomItem>,
        itemWidth: Int,
        bottomItemClickInterface: BottomItemClickInterface
    ) : this() {
        this.bottomItems = bottomItems
        this.itemWidth = itemWidth
        this.selected = selected
        this.bottomItemClickInterface = bottomItemClickInterface

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.bottom_bar_item, parent, false)
        return BottomBarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bottomItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        resizeItemWidth((holder as BottomBarViewHolder).bottom_parent)
        setIcon((holder as BottomBarViewHolder).bottom_icon, bottomItems[position].itemIconId)
        selectedStyle(
            (holder as BottomBarViewHolder).bottom_icon,
            bottomItems[position].itemId,
            bottomItems[position].itemIconId,
            bottomItems[position].itemFillIconId
        )

        visibilityChange(
            (holder as BottomBarViewHolder).bottom_notification,
            bottomItems[position].isHasNotification
        )

        setOnClickItem(
            (holder as BottomBarViewHolder).bottom_item_parent,
            (holder as BottomBarViewHolder).bottom_icon, position,
            bottomItems[position].itemId,
            bottomItems[position].itemIconId,
            bottomItems[position].itemFillIconId
        )
    }

    private fun setIcon(imageView: ImageView, iconId: Int) {
        imageView.setImageResource(iconId)
    }

    private fun visibilityChange(cardView: CardView, isVisible: Boolean) {
        if (isVisible) {
            cardView.visibility = View.VISIBLE
        } else {
            cardView.visibility = View.GONE
        }
    }

    private fun selectedStyle(
        imageView: ImageView,
        itemId: Int,
        itemDefIcon: Int,
        itemFillIcon: Int
    ) {
        if (itemId == selected) {
            imageView.setImageResource(itemFillIcon)
        } else {
            imageView.setImageResource(itemDefIcon)
        }
    }

    private fun resizeItemWidth(parent: RelativeLayout) {
        parent.layoutParams.width = itemWidth
    }

    private fun setOnClickItem(
        parent: RelativeLayout,
        imageView: ImageView,
        position: Int,
        itemId: Int,
        itemDefIcon: Int,
        itemFillIcon: Int
    ) {
        parent.setOnClickListener {
            bottomItemClickInterface.itemSelect(itemId)
            selected = itemId
            bottomItems[position].isHasNotification = false
            selectedStyle(imageView, itemId, itemDefIcon, itemFillIcon)
            notifyDataSetChanged()
        }
    }

    interface BottomItemClickInterface {
        fun itemSelect(itemId: Int)
    }

    class BottomBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bottom_item_parent: RelativeLayout
        var bottom_parent: RelativeLayout
        var bottom_icon: ImageView
        var bottom_notification: CardView

        init {
            bottom_item_parent = itemView.findViewById(R.id.bottom_item_parent)
            bottom_parent = itemView.findViewById(R.id.bottom_parent)
            bottom_icon = itemView.findViewById(R.id.bottom_icon)
            bottom_notification = itemView.findViewById(R.id.bottom_notification)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(selected)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BottomBarAdapter> {
        override fun createFromParcel(parcel: Parcel): BottomBarAdapter {
            return BottomBarAdapter(parcel)
        }

        override fun newArray(size: Int): Array<BottomBarAdapter?> {
            return arrayOfNulls(size)
        }
    }
}