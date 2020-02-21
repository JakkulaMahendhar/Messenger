package com.example.kotlinpractice

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_settings.*
import java.lang.Exception

const val KEY_CURRENT_THEME = "current_theme"
const val LILAC_THEME = "lilac"
const val MINT_THEME = "mint"
private lateinit var sharedPref: SharedPreferences
private lateinit var currentTheme: String

class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_settings)

            sharedPref = applicationContext.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
            currentTheme = sharedPref.getString(KEY_CURRENT_THEME, LILAC_THEME)!!

            mintTheme.isChecked = currentTheme == MINT_THEME
            mintTheme.setOnCheckedChangeListener { view, isChecked ->
                if (isChecked)
                    sharedPref.edit().putString(KEY_CURRENT_THEME, MINT_THEME).apply()
                else
                    sharedPref.edit().putString(KEY_CURRENT_THEME, LILAC_THEME).apply()
                recreate()
            }
        } catch (e: Exception) {
            e.message
        }
    }
}

