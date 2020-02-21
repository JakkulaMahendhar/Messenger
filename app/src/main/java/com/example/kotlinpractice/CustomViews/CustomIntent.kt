package com.example.kotlinpractice

import android.app.Activity
import android.content.Context


class CustomIntent {

    var types = arrayOf("", "")

    fun customType(context: Context, animtype: String) {
        val act = context as Activity
        when (animtype) {
            "left-to-right" -> act.overridePendingTransition(
                R.anim.push_left_in,
                R.anim.push_left_out
            )
            "right-to-left" -> act.overridePendingTransition(
                R.anim.left_to_right,
                R.anim.right_to_left
            )
            "bottom-to-up" -> act.overridePendingTransition(
                R.anim.bottom_to_up,
                R.anim.up_to_bottom
            )
            "up-to-bottom" -> act.overridePendingTransition(
                R.anim.up_to_bottom2,
                R.anim.bottom_to_up2
            )
            "fadein-to-fadeout" -> act.overridePendingTransition(
                R.anim.fade_in,
                R.anim.fade_out
            )
            "rotateout-to-rotatein" -> act.overridePendingTransition(
                R.anim.rotatein_out,
                R.anim.rotateout_in
            )
            else -> {
            }
        }
    }
}