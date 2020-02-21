package com.example.kotlinpractice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import java.nio.file.Files.size
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.palette.graphics.Palette
import java.util.*


class ChatActivity : AppCompatActivity() {

    var icon: Bitmap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val bundle = intent.getBundleExtra("Bundle")
        val type = intent.getStringExtra("viewtype")

        if (type.equals("1")) {
            val data = bundle.getParcelable<UserFavouriteModel>("key")
            data?.image?.let { user_img.setImageResource(it) }
//            icon = BitmapFactory.decodeResource(applicationContext.resources, data!!.image)
//            createPaletteAsync(this.icon!!)
            //icon?.let { user_img.setImageBitmap(it) }
            data?.name?.let { user_name.setText(it) }

        } else {
            val data = bundle.getParcelable<UsersMessageModel>("key")
            data?.image?.let { user_img.setImageResource(it) }
            data?.name?.let { user_name.setText(it) }
        }


        val arrayList = ArrayList<ChatObject>()




        img_send.setOnClickListener {

            val message = user_message.text.toString()
            val chatUser = ChatObject(message)


            arrayList.add(chatUser)

            val adapter = ChatUserAdapter(this, arrayList)

            val linearLayoutManager = LinearLayoutManager(this)
            recycler_view_chat.layoutManager = linearLayoutManager
            recycler_view_chat.animation =
                AnimationUtils.loadAnimation(this, R.anim.slide_in_righ)
            recycler_view_chat.adapter = adapter

            user_message.setText("")
            recycler_view_chat.notifyDataSetChanged()
        }
    }

    fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate { palette ->
            val vibrant = palette?.vibrantSwatch
        }
    }

//    fun latestmessages(arrayList: ArrayList<ChatObject>): ArrayList<ChatObject> {
//
//        for (i in 0..arrayList.size) {
//
//
//
//        }
//    }
}
