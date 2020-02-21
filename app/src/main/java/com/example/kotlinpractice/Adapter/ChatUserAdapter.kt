package com.example.kotlinpractice

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ChatUserAdapter() :
    RecyclerView.Adapter<ChatUserAdapter.ViewHolder>() {


    var context: Context? = null
    var userlist: ArrayList<ChatObject>? = null
    var itemClickListener: OnItemClickListener? = null

    constructor(
        context: Context,
        userlist: ArrayList<ChatObject>
    ) : this() {
        this.context = context
        this.userlist = userlist

    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatUserAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.chatuserview, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(context!!, userlist?.get(position)!!)

    }


    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userlist!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(
            context: Context,
            user: ChatObject
        ) {
            val userImage = itemView.findViewById(R.id.tv_input_text) as TextView

            userImage.text = user.text

        }
    }
}