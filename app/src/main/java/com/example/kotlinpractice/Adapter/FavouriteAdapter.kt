package com.example.kotlinpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class FavouriteAdapter() :
    RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {
    var context: Context? = null
    var userlist: ArrayList<UserFavouriteModel>? = null
    var itemClickListener: OnItemClickListener? = null

    constructor(
        context: Context,
        userlist: ArrayList<UserFavouriteModel>,
        itemClick: OnItemClickListener
    ) : this() {
        this.context = context
        this.userlist = userlist
        this.itemClickListener = itemClick
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.circular_recycler_view, parent, false)
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
            user: UserFavouriteModel,
            itemClickListener: OnItemClickListener?
        ) {
            val ll_favview = itemView.findViewById(R.id.ll_favview) as LinearLayout
            val userImage = itemView.findViewById(R.id.user_img) as CircleImageView
            val textViewAddress = itemView.findViewById(R.id.user_img_name) as TextView
//            if (HomeFragment.onAnimation().) {
//                userImage.animation =
//                    AnimationUtils.loadAnimation(context, R.anim.slide_in_right_latest)
//                textViewAddress.animation =
//                    AnimationUtils.loadAnimation(context, R.anim.slide_right_fav)
//            }
            userImage.setImageResource(user.image)
            textViewAddress.text = user.name

            ll_favview.setOnClickListener {
                itemClickListener?.onItemClicked(user, ll_favview)
            }
        }
    }
}