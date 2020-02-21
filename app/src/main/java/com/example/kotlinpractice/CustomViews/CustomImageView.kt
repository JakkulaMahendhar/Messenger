package com.example.kotlinpractice

import android.content.Context
import android.widget.ImageView

class CustomImageView(context: Context?) : ImageView(context) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var Height = MeasureSpec.getSize(widthMeasureSpec) * 2 / 3
        var HeightSpec = MeasureSpec.makeMeasureSpec(Height, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, HeightSpec)

    }


}