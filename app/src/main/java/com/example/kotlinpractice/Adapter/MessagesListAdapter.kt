package com.example.kotlinpractice

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MessagesListAdapter() :
    RecyclerView.Adapter<MessagesListAdapter.ViewHolder>() {


    var context: Context? = null
    var userlist: ArrayList<UsersMessageModel>? = null
    var itemClickListener: OnItemClickListener? = null

    constructor(
        context: Context,
        userlist: ArrayList<UsersMessageModel>,
        itemClick: OnItemClickListener
    ) : this() {
        this.context = context
        this.userlist = userlist
        this.itemClickListener = itemClick
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessagesListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.messages_list, parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(context!!, userlist?.get(position)!!, itemClickListener)

    }


    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userlist!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(
            context: Context,
            user: UsersMessageModel,
            itemClickListener: OnItemClickListener?
        ) {
            val userImage = itemView.findViewById(R.id.user_img) as CircleImageView
            val textViewAddress = itemView.findViewById(R.id.user_img_name) as AppCompatTextView
            val usermsg = itemView.findViewById(R.id.user_img_msg) as AppCompatTextView
            val userday = itemView.findViewById(R.id.user_img_day_time) as AppCompatTextView
            val usertype = itemView.findViewById(R.id.user_img_type) as AppCompatTextView
            val rl_rootview = itemView.findViewById(R.id.rl_rootview) as RelativeLayout
//            userImage.animation =
//                AnimationUtils.loadAnimation(context, R.anim.slide_in_right_latest)
//            textViewAddress.animation =
//                AnimationUtils.loadAnimation(context, R.anim.slide_in_righ)
            userImage.setImageResource(user.image)
            textViewAddress.text = user.name
            usermsg.text = user.message
            userday.text = user.day
            usertype.text = user.type
            if (usertype.text.equals("")) {
                usertype.setBackgroundColor(Color.WHITE)
            }
            rl_rootview.setOnClickListener {
                itemClickListener?.onItemClicked(user, rl_rootview)
            }

        }
    }
}
