package com.example.kotlinpractice

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mlsdev.animatedrv.AnimatedRecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import android.app.Activity
import android.content.Intent


class HomeFragment : Fragment(R.layout.fragment_home), OnItemClickListener {


    var appContext: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fav_tag.animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)

        fav_tag1.animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)

        fav_tag_options.animation =
            AnimationUtils.loadAnimation(context, R.anim.slide_in_right_latest)

        val recyclerView = view.findViewById(R.id.recycler_fav_horizontal) as RecyclerView
        val recycler_view_animated =
            view.findViewById(R.id.recycler_view_animated) as AnimatedRecyclerView

        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        recycler_view_animated.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)


        val users = ArrayList<UserFavouriteModel>()

        users.add(UserFavouriteModel(R.drawable.user_100px, "John"))
        users.add(UserFavouriteModel(R.drawable.user_male_100px, "Ali"))
        users.add(UserFavouriteModel(R.drawable.user_male_100px, "Chotu"))
        users.add(UserFavouriteModel(R.drawable.user_100px, "Sai"))

        users.add(UserFavouriteModel(R.drawable.user_100px, "Bharath"))
        users.add(UserFavouriteModel(R.drawable.user_100px, "Sony"))


        val usersmessages = ArrayList<UsersMessageModel>()

        usersmessages.add(
            UsersMessageModel(
                R.drawable.user_100px,
                "Mahendhar",
                "Yeah! i'm cool",
                "Fri",
                ""
            )
        )
        usersmessages.add(
            UsersMessageModel(
                R.drawable.user_male_100px,
                "James",
                "Yeah! i'm cool",
                "Sat",
                "New"
            )
        )
        usersmessages.add(
            UsersMessageModel(
                R.drawable.user_100px,
                "Sandy",
                "Yeah! i'm cool",
                "Mon",
                ""
            )
        )

        usersmessages.add(
            UsersMessageModel(
                R.drawable.user_100px,
                "Krish",
                "Yeah! i'm cool",
                "Sat",
                ""
            )
        )
        usersmessages.add(
            UsersMessageModel(
                R.drawable.user_male_100px,
                "John",
                "Yeah! i'm cool",
                "Sat",
                "New"
            )
        )
        usersmessages.add(
            UsersMessageModel(
                R.drawable.user_male_100px,
                "Stella",
                "Yeah! i'm cool",
                "Sun",
                "New"
            )
        )
        usersmessages.add(
            UsersMessageModel(
                R.drawable.user_100px,
                "Shiva",
                "Yeah! i'm cool",
                "Tue",
                ""
            )
        )

        val adapter = FavouriteAdapter(appContext!!, users, this)

        recyclerView.animation =
            AnimationUtils.loadAnimation(appContext!!, R.anim.slide_in_right_latest)
        recyclerView.adapter = adapter
        // isAnimationStatedFavouriteView = false

        val msgAdapter = MessagesListAdapter(appContext!!, usersmessages, this)

        recycler_view_animated.adapter = msgAdapter

//        recycler_view_animated.addItemDecoration(
//            DividerItemDecoration(
//                recyclerView.context,
//                DividerItemDecoration.VERTICAL
//            )
//        )
        msgAdapter.notifyDataSetChanged()
        adapter.notifyDataSetChanged()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)


        if (context is HomeActivity) {
            appContext = context

        }
    }


    override fun onDetach() {
        super.onDetach()
    }


    companion object {
        fun newInstance(): HomeFragment {
            val fragmentHome = HomeFragment()
            val args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome

        }


    }

    override fun onItemClicked(objects: Any, view: View) {
        val tagview = view.getTag()
        if (tagview.equals("1")) {
            val userFavouriteModel = objects as UserFavouriteModel
            val intent = Intent(appContext, ChatActivity::class.java)
            val bundle = Bundle()
            val parcel = UserFavouriteModel(
                userFavouriteModel.image,
                userFavouriteModel.name
            )


            bundle.putParcelable("key", parcel)
            intent.putExtra("Bundle", bundle)
            intent.putExtra("viewtype", tagview as String)
            startActivity(intent)
            val customIntent = CustomIntent()
            customIntent.customType(this.context!!, "left-to-right")

        }
        if (tagview.equals("2")) {

            val userMessageDo = objects as UsersMessageModel
            val intent = Intent(appContext, ChatActivity::class.java)
            val bundle = Bundle()
            val parcel = UsersMessageModel(
                userMessageDo.image,
                userMessageDo.name,
                userMessageDo.message,
                userMessageDo.day,
                userMessageDo.type
            )


            bundle.putParcelable("key", parcel)
            intent.putExtra("Bundle", bundle)
            intent.putExtra("viewtype", tagview as String)
            startActivity(intent)
            val customIntent = CustomIntent()
            customIntent.customType(this.context!!, "right-to-left")
        }
    }
}
