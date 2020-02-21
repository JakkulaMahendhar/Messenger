package com.example.kotlinpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mlsdev.animatedrv.AnimatedRecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(),
    BottomBarAdapter.BottomItemClickInterface {

    private var customBottomBar: CustomBottomBar? = null

    private var MESSAGES = 0
    private var SEARCH = 1
    private var GROUPS = 2
    private var LIKES = 3
    private var CONTACTS = 4


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        customBottomBar = CustomBottomBar(
            findViewById(R.id.customBottomBar),
            this@HomeActivity,
            this@HomeActivity
        )

        initBottomItems()

        val fragment = HomeFragment.Companion.newInstance()
        addFragment(fragment)


    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
//            .addToBackStack(null)
            .commit()

    }

    private fun initBottomItems() {
        val home = BottomItem(
            MESSAGES,
            R.drawable.messages_icon,
            R.drawable.messages_fill,
            false
        )
//        val search = BottomItem(
//            SEARCH,
//            R.drawable.search,
//            R.drawable.searchfill,
//            false
//        )
        val upload = BottomItem(
            GROUPS,
            R.drawable.groups_icon,
            R.drawable.groups_fill,
            false
        )
//        val likes = BottomItem(
//            LIKES,
//            R.drawable.likes,
//            R.drawable.likesfill,
//            true
//        )
        val profile = BottomItem(
            CONTACTS,
            R.drawable.user_icon,
            R.drawable.user_fill,
            false
        )

        customBottomBar?.addBottomItem(home)
        //customBottomBar?.addBottomItem(search)
        customBottomBar?.addBottomItem(upload)
        //customBottomBar?.addBottomItem(likes)
        customBottomBar?.addBottomItem(profile)

        customBottomBar?.apply(MESSAGES)
    }


    override fun itemSelect(itemId: Int) {
        when (itemId) {
            MESSAGES -> {
                val fragment = HomeFragment.Companion.newInstance()
                addFragment(fragment)

            }
            CONTACTS -> {
                val fragment = ContactsFragment.Companion.newInstance()
                addFragment(fragment)

            }
            GROUPS -> {
                val fragment = GroupsFragment.Companion.newInstance()
                addFragment(fragment)
            }

//            PROFILE -> {
//                val fragment = ProfileFragment()
//                addFragment(fragment)
//            }
        }
    }
}
