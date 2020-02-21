package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.animation.ObjectAnimator
import android.animation.Animator
import android.view.animation.AccelerateDecelerateInterpolator
import android.animation.AnimatorSet
import android.annotation.SuppressLint


class GroupsOnlineViewActivity : AppCompatActivity() {

    private var foundDevice: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups_online_view)

        val rippleBackground = findViewById<View>(R.id.content) as RippleBackground

        val handler = Handler()

        foundDevice = findViewById(R.id.foundDevice) as ImageView
        val button = findViewById(R.id.centerImage) as ImageView

        rippleBackground.startRippleAnimation()
        handler.postDelayed(Runnable { foundDevice() }, 3000)
    }


    @SuppressLint("ObjectAnimatorBinding")
    private fun foundDevice() {
        val animatorSet = AnimatorSet()
        animatorSet.duration = 400
        animatorSet.interpolator = AccelerateDecelerateInterpolator()
        val animatorList = ArrayList<Animator>()
        val scaleXAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleX", 0f, 1.2f, 1f)
        animatorList.add(scaleXAnimator)
        val scaleYAnimator = ObjectAnimator.ofFloat(foundDevice, "ScaleY", 0f, 1.2f, 1f)
        animatorList.add(scaleYAnimator)
        animatorSet.playTogether(animatorList)
        foundDevice?.setVisibility(View.VISIBLE)
        animatorSet.start()
    }
}
