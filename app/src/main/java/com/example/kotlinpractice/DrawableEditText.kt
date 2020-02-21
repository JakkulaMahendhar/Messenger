package com.example.kotlinpractice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import android.graphics.drawable.Drawable
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.MotionEvent
import com.example.kotlinpractice.DrawableClickListener
import androidx.core.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.kotlinpractice.databinding.ActivityLoginBinding
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.example.kotlinpractice.UserViewModel


class DrawableEditText : AppCompatEditText {

    private var drawableRight: Drawable? = null
    private var drawableLeft: Drawable? = null
    private var drawableTop: Drawable? = null
    private var drawableBottom: Drawable? = null
    var actionX: Int = 0
    var actionY: Int = 0
    var mHeight: Int = 0
    private var clickListener: DrawableClickListener? = null

    var mBinding: ActivityLoginBinding? = null

    constructor(context: Context?) : super(context){
        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mBinding = ActivityLoginBinding.inflate(inflater)
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        mHeight = h
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun setCompoundDrawables(
        left: Drawable?,
        top: Drawable?,
        right: Drawable?,
        bottom: Drawable?
    ) {
        if (left != null) {
            drawableLeft = left;
        }
        if (right != null) {
            drawableRight = right;
        }
        if (top != null) {
            drawableTop = top;
        }
        if (bottom != null) {
            drawableBottom = bottom;
        }
        super.setCompoundDrawables(left, top, right, bottom)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        try {
            var bounds: Rect?
            if (event!!.getAction() === MotionEvent.ACTION_DOWN) {
                actionX = event!!.getX().toInt()
                actionY = event.getY().toInt()
                if (drawableBottom != null && drawableBottom!!.getBounds().contains(
                        actionX,
                        actionY
                    )
                ) {
                    clickListener!!.onClick(DrawableClickListener.DrawablePosition.BOTTOM)
                    return super.onTouchEvent(event)
                }

                if (drawableTop != null && drawableTop!!.getBounds().contains(actionX, actionY)) {
                    clickListener!!.onClick(DrawableClickListener.DrawablePosition.TOP)
                    return super.onTouchEvent(event)
                }

                // this works for left since container shares 0,0 origin with bounds
                if (drawableLeft != null) {
                    bounds = null
                    bounds = drawableLeft!!.getBounds()

                    var x: Int
                    var y: Int
                    val density = resources.displayMetrics.density
                    val extraTapArea = (13 * density + 0.5).toInt()

                    x = actionX
                    y = actionY

                    if (!bounds!!.contains(actionX, actionY)) {
                        /* Gives the +20 area for tapping. */
                        x = actionX - extraTapArea
                        y = actionY - extraTapArea

                        if (x <= 0)
                            x = actionX
                        if (y <= 0)
                            y = actionY

                        /* Creates square from the smallest value */
                        if (x < y) {
                            y = x
                        }
                    }

                    if (bounds!!.contains(x, y) && clickListener != null) {
                        clickListener!!.onClick(DrawableClickListener.DrawablePosition.LEFT)
                        event.setAction(MotionEvent.ACTION_CANCEL)
                        return false

                    }
                }

                if (drawableRight != null) {
                    bounds = drawableRight!!.getBounds()

                    var x: Int
                    var y: Int
                    val density = resources.displayMetrics.density
                    val extraTapArea = (13 * density + 0.5).toInt()

                    /*
                 * IF USER CLICKS JUST OUT SIDE THE RECTANGLE OF THE DRAWABLE
                 * THAN ADD X AND SUBTRACT THE Y WITH SOME VALUE SO THAT AFTER
                 * CALCULATING X AND Y CO-ORDINATE LIES INTO THE DRAWBABLE
                 * BOUND. - this process help to increase the tappable area of
                 * the rectangle.
                 */
                    x = actionX + extraTapArea
                    y = actionY - extraTapArea

                    /*Since this is right drawable subtract the value of x from the width
                 * of view. so that width - tappedarea will result in x co-ordinate in drawable bound.
                 */
                    x = width - x

                    /*x can be negative if user taps at x co-ordinate just near the width.
                 * e.g views width = 300 and user taps 290. Then as per previous calculation
                 * 290 + 13 = 303. So subtract X from getWidth() will result in negative value.
                 * So to avoid this add the value previous added when x goes negative.
                 */

                    if (x <= 0) {
                        x += extraTapArea
                    }

                    /* If result after calculating for extra tappable area is negative.
                 * assign the original value so that after subtracting
                 * extratapping area value doesn't go into negative value.
                 */

                    if (y <= 0)
                        y = actionY

                    /*If drawble bounds contains the x and y points then move ahead.*/
                    if (bounds!!.contains(x, y) && clickListener != null) {
                        clickListener!!.onClick(DrawableClickListener.DrawablePosition.RIGHT)
                        event!!.setAction(MotionEvent.ACTION_CANCEL)
                        return false
                    }
                    return super.onTouchEvent(event)
                }

            }
        }catch (e:Exception){
            e.message
        }
        return super.onTouchEvent(event)

    }

    @Throws(Throwable::class)
    protected fun finalize() {
        drawableRight = null
        drawableBottom = null
        drawableLeft = null
        drawableTop = null
    }

    fun setDrawableClickListener(listener: DrawableClickListener) {
        this.clickListener = listener
    }

//    fun setMyViewModel(obj: UserViewModel) {
//        mBinding.setMyViewModel(obj)
//    }
}