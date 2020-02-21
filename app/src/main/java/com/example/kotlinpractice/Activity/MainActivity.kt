package com.example.kotlinpractice

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinpractice.databinding.ActivityLoginBinding
import com.example.kotlinpractice.databinding.ActivityMainBinding
import mvvm.livedata.example.viewmodel.factory.UserViewModelFactory
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    var TAG: String = UserViewModel::class.java.simpleName

    val UPDATE_NOTE_ACTIVITY_REQUEST_CODE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)

            val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)

//            user_tag.setPaintFlags(user_tag.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
//
//            val userdata = intent.getParcelableExtra("USER_OBJ") as Parcelable
//            Log.d(TAG, userdata.toString())
//
//            email.text = (userdata as UserEntity).email

            val mainviewmodel =
                ViewModelProviders.of(
                    this,
                    MainViewModelFactory(this, UserEntity("", "", ""), application)
                )
                    .get(MainActivityViewModel::class.java)

            binding.mainviewmodel = mainviewmodel

        } catch (e: Exception) {
            e.message
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.settings)
            startActivity(Intent(this, SettingsActivity::class.java))

        return super.onOptionsItemSelected(item)
    }


}
