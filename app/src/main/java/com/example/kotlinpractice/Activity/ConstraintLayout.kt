package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_constraint_layout.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View


class ConstraintLayout : AppCompatActivity() {

    var textview: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        val textview = TextView(this)
        textview?.text = "Dynamically added TextView"
        textview?.gravity = Gravity.CENTER

        view_flipper.addView(textview)
        view_flipper.setFlipInterval(2000);
        view_flipper.startFlipping();
    }

    fun previousView(v: View) {
        view_flipper.setInAnimation(this, R.anim.slide_in_righ);
        view_flipper.setOutAnimation(this, R.anim.slide_out_left);
        view_flipper.showPrevious();
    }

    fun nextView(v: View) {
        view_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        view_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        view_flipper.showNext();
    }
}
