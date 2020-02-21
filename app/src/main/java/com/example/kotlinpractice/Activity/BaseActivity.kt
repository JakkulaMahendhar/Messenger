package com.example.kotlinpractice

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import android.R.id.edit
import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    private lateinit var currentTheme: String
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val eulaKey = "mykey"
        val mContext = applicationContext
        sharedPref = mContext.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean(eulaKey, true)
        currentTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)!!
        setAppTheme(currentTheme)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        val selectedTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)
        if (currentTheme != selectedTheme)
            recreate()
    }

    private fun setAppTheme(currentTheme: String) {
        when (currentTheme) {
            MINT_THEME -> setTheme(R.style.Theme_App_Mint)
            else -> setTheme(R.style.Theme_App_Lilac)
        }
    }
}