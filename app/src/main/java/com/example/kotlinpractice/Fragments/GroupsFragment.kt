package com.example.kotlinpractice

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import android.graphics.drawable.AnimatedVectorDrawable
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat


class GroupsFragment : Fragment() {

    private var tickCross: ImageView? = null
    private var tickToCross: AnimatedVectorDrawableCompat? = null
    private var crossToTick: AnimatedVectorDrawableCompat? = null
    private var tick = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_groups, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fab: View = view.findViewById(R.id.add_groups)
        fab.setOnClickListener { view ->
            val intent: Intent = Intent(context, GroupsOnlineViewActivity::class.java)
            startActivity(intent)
//            Snackbar.make(view, "Groups Creation is under developed", Snackbar.LENGTH_LONG)
//                .show()


        }

//        tickCross = view.findViewById(R.id.tick_cross);
//        tickToCross =
//            getDrawable(context!!, R.drawable.avd_tick_to_cross) as AnimatedVectorDrawableCompat;
//        crossToTick =
//            getDrawable(context!!, R.drawable.avd_cross_to_tick) as AnimatedVectorDrawableCompat?;
//
//        tickCross?.setOnClickListener {
//            animate(view)
//        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }

    fun animate(view: View) {
        val drawable = if (tick) tickToCross else crossToTick
        tickCross!!.setImageDrawable(drawable)
        drawable!!.start()
        tick = !tick
    }


    companion object {
        fun newInstance(): GroupsFragment {
            var fragmentGroups = GroupsFragment()
            var args = Bundle()
            fragmentGroups.arguments = args
            return fragmentGroups

        }


    }
}
