package com.example.kotlinpractice

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CustomBottomBar {

    private val ITEM_LIMIT = 5
    private var context: Context? = null
    private var recyclerView: RecyclerView? = null
    private var bottomItems: ArrayList<BottomItem>? = null
    private var bottomItemClickInterface: BottomBarAdapter.BottomItemClickInterface? = null

    constructor(
        view: View,
        context: Context,
        bottomItemClickInterface: BottomBarAdapter.BottomItemClickInterface
    ) {
        this.context = context
        this.bottomItemClickInterface = bottomItemClickInterface
        setType(view)

    }

    private fun setType(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        bottomItems = ArrayList<BottomItem>()
    }

    fun addBottomItem(item: BottomItem) {
        if (bottomItems?.size != ITEM_LIMIT) {
            bottomItems?.add(item)
        }
    }

    private fun setAdapter(selected: Int) {
        val bottomAdapter =
            BottomBarAdapter(
                selected,
                this!!.bottomItems!!, calculateItemWidth(), this!!.bottomItemClickInterface!!
            )
        recyclerView?.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerView?.setAdapter(bottomAdapter)
    }

    private fun calculateItemWidth(): Int {
        val mCount = bottomItems?.size?.plus(1)
        val mWidth = context?.getResources()?.displayMetrics?.widthPixels
        return mWidth!! / mCount!!
    }

    fun apply(selected: Int) {
        setAdapter(selected)
    }
}
