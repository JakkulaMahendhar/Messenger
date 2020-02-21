package com.example.kotlinpractice

import androidx.core.os.HandlerCompat.postDelayed
import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import android.view.View.MeasureSpec
import android.os.Bundle
import android.os.Parcelable
import android.os.Build
import android.annotation.TargetApi
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import androidx.core.view.postDelayed


internal class CustomCheckBox : View, Checkable {

    private var mPaint: Paint? = null
    private var mTickPaint: Paint? = null
    private var mFloorPaint: Paint? = null
    private  lateinit  var mTickPoints: Array<Point?>
    private var mCenterPoint: Point? = null
    private var mTickPath: Path? = null

    private var mLeftLineDistance: Float = 0.toFloat()
    private var mRightLineDistance: Float = 0.toFloat()
    private var mDrewDistance: Float = 0.toFloat()
    private var mScaleVal = 1.0f
    private var mFloorScale = 1.0f
    private var mWidth: Int = 0
    private var mAnimDuration: Int = 0
    private var mStrokeWidth: Int = 0
    private var mTickColor = Color.WHITE
    var checkedColor: Int = 0
    var unCheckedColor: Int = 0
    var floorColor: Int = 0
    var floorUnCheckedColor: Int = 0

    private var mChecked: Boolean = false
    private var mTickDrawing: Boolean = false
    private var mListener: OnCheckedChangeListener? = null
    var isSmallTick: Boolean = false

    var tickColor: Int
        get() = mTickColor
        set(color) {
            mTickColor = color
            mTickPaint!!.setColor(mTickColor)
        }

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {

        val ta = getContext().obtainStyledAttributes(attrs, R.styleable.CustomCheckBox)
        mTickColor = ta.getColor(R.styleable.CustomCheckBox_color_tick, COLOR_TICK)
        mAnimDuration = ta.getInt(R.styleable.CustomCheckBox_duration, DEF_ANIM_DURATION)
        floorColor =
            ta.getColor(R.styleable.CustomCheckBox_color_unchecked_stroke, COLOR_FLOOR_UNCHECKED)
        checkedColor = ta.getColor(R.styleable.CustomCheckBox_color_checked, COLOR_CHECKED)
        unCheckedColor = ta.getColor(R.styleable.CustomCheckBox_color_unchecked, COLOR_UNCHECKED)
        mStrokeWidth = ta.getDimensionPixelSize(
            R.styleable.CustomCheckBox_stroke_width,
            dp2px(getContext(), 0f)
        )
        isSmallTick = ta.getBoolean(R.styleable.CustomCheckBox_small_tick, false)
        ta.recycle()

        floorUnCheckedColor = floorColor
        mTickPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mTickPaint!!.setStyle(Paint.Style.STROKE)
        mTickPaint!!.setStrokeCap(Paint.Cap.SQUARE)
        mTickPaint!!.setColor(mTickColor)

        mFloorPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mFloorPaint!!.setStyle(Paint.Style.FILL)
        mFloorPaint!!.setColor(floorColor)

        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.setStyle(Paint.Style.FILL)
        mPaint!!.setColor(checkedColor)

        mTickPath = Path()
        mCenterPoint = Point()
        mTickPoints = arrayOfNulls<Point>(3)
        mTickPoints[0] = Point()
        mTickPoints[1] = Point()
        mTickPoints[2] = Point()

        setOnClickListener(object : OnClickListener {
            override fun onClick(v: View) {
                toggle()
                mTickDrawing = false
                mDrewDistance = 0f
                if (isChecked) {
                    startCheckedAnimation()
                } else {
                    startUnCheckedAnimation()
                }
            }
        })
    }

    protected override fun onSaveInstanceState(): Parcelable {
        val bundle = Bundle()
        bundle.putParcelable(KEY_INSTANCE_STATE, super.onSaveInstanceState())
        bundle.putBoolean(KEY_INSTANCE_STATE, isChecked)
        return bundle
    }

    protected override fun onRestoreInstanceState(state: Parcelable) {
        if (state is Bundle) {
            val isChecked = state.getBoolean(KEY_INSTANCE_STATE)
            setChecked(isChecked)
            super.onRestoreInstanceState(state.getParcelable<Parcelable>(KEY_INSTANCE_STATE))
            return
        }
        super.onRestoreInstanceState(state)
    }

    override fun isChecked(): Boolean {
        return mChecked
    }

    override fun toggle() {
        this.isChecked = !isChecked
    }

    override fun setChecked(checked: Boolean) {
        mChecked = checked
        reset()
        invalidate()
        if (mListener != null) {
            mListener!!.onCheckedChanged(this@CustomCheckBox, mChecked)
        }
    }

    /**
     * checked with animation
     *
     * @param checked checked
     * @param animate change with animation
     */
    fun setChecked(checked: Boolean, animate: Boolean) {
        if (animate) {
            mTickDrawing = false
            mChecked = checked
            mDrewDistance = 0f
            if (checked) {
                startCheckedAnimation()
            } else {
                startUnCheckedAnimation()
            }
            if (mListener != null) {
                mListener!!.onCheckedChanged(this@CustomCheckBox, mChecked)
            }

        } else {
            this.isChecked = checked
        }
    }

    private fun reset() {
        mTickDrawing = true
        mFloorScale = 1.0f
        mScaleVal = if (isChecked) 0f else 1.0f
        floorColor = if (isChecked) checkedColor else floorUnCheckedColor
        mDrewDistance = if (isChecked) mLeftLineDistance + mRightLineDistance else 0F
    }

    protected override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(DEF_DRAW_SIZE, widthSize)
        } else {
            //Be whatever you want
            width = DEF_DRAW_SIZE
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(DEF_DRAW_SIZE, heightSize)
        } else {
            //Be whatever you want
            height = DEF_DRAW_SIZE
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height)
    }

    protected override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        try {
            mWidth = getMeasuredWidth()
            val totalPoints: Int
            if (isSmallTick) {
                totalPoints = 30
            } else {
                totalPoints = 11
            }
            mStrokeWidth = getMeasuredWidth() / totalPoints

            mCenterPoint!!.x = mWidth / 2
            mCenterPoint!!.y = getMeasuredHeight() / 2

            val widthUnity = getMeasuredWidth().toFloat() / totalPoints
            val heightUnity = getMeasuredHeight() as Float / totalPoints

            if (isSmallTick) {
                mTickPoints!![0]!!.x = Math.round(widthUnity * 11)
                mTickPoints!![0]!!.y = Math.round(heightUnity * 15)

                mTickPoints!![1]!!.x = Math.round(widthUnity * 14)
                mTickPoints!![1]!!.y = Math.round(heightUnity * 18)

                mTickPoints!![2]!!.x = Math.round(widthUnity * 20)
                mTickPoints!![2]!!.y = Math.round(heightUnity * 13)

            } else {
                mTickPoints!![0]!!.x = Math.round(widthUnity * 1)
                mTickPoints!![0]!!.y = Math.round(heightUnity * 5)

                mTickPoints!![1]!!.x = Math.round(widthUnity * 4)
                mTickPoints!![1]!!.y = Math.round(heightUnity * 8)

                mTickPoints!![2]!!.x = Math.round(widthUnity * 10)
                mTickPoints!![2]!!.y = Math.round(heightUnity * 3)
            }

            mLeftLineDistance = Math.sqrt(
                Math.pow(
                    (mTickPoints!![1]!!.x - mTickPoints!![0]!!.x).toDouble(),
                    2.0
                ) + Math.pow((mTickPoints!![1]!!.y - mTickPoints!![0]!!.y).toDouble(), 2.0)
            ).toFloat()
            mRightLineDistance = Math.sqrt(
                Math.pow(
                    (mTickPoints!![2]!!.x - mTickPoints!![1]!!.x).toDouble(),
                    2.0
                ) + Math.pow((mTickPoints!![2]!!.y - mTickPoints!![1]!!.y).toDouble(), 2.0)
            ).toFloat()
            mTickPaint!!.setStrokeWidth(mStrokeWidth.toFloat())
        }catch (e:Exception){
            e.message
        }
    }

    protected override fun onDraw(canvas: Canvas) {
        drawBorder(canvas)
        drawCenter(canvas)
        drawTick(canvas)
    }

    private fun drawCenter(canvas: Canvas) {
        mPaint!!.setColor(unCheckedColor)
        val radius = (mCenterPoint!!.x - mStrokeWidth) * mScaleVal
        canvas.drawCircle(mCenterPoint!!.x.toFloat(), mCenterPoint!!.y.toFloat(), radius, mPaint!!)
    }

    private fun drawBorder(canvas: Canvas) {
        mFloorPaint!!.setColor(floorColor)
        val radius = mCenterPoint!!.x
        canvas.drawCircle(mCenterPoint!!.x.toFloat(),
            mCenterPoint!!.y.toFloat(), radius * mFloorScale, mFloorPaint!!)
    }

    private fun drawTick(canvas: Canvas) {
        if (mTickDrawing && isChecked) {
            drawTickPath(canvas)
        }
    }

    private operator fun Float.plus(step: Any): Float {
        mDrewDistance = mDrewDistance+step
        return mDrewDistance
    }

    private fun drawTickPath(canvas: Canvas) {
        mTickPath!!.reset()
        // draw left of the tick
        if (mDrewDistance < mLeftLineDistance) {
            val step = if (mWidth / 20.0f < 3) 3 else mWidth / 20.0f
            mDrewDistance = mDrewDistance+step
            val stopX =
                mTickPoints!![0]!!.x + (mTickPoints!![1]!!.x - mTickPoints!![0]!!.x) * mDrewDistance / mLeftLineDistance
            val stopY =
                mTickPoints!![0]!!.y + (mTickPoints!![1]!!.y - mTickPoints!![0]!!.y) * mDrewDistance / mLeftLineDistance

            mTickPath!!.moveTo(mTickPoints!![0]!!.x.toFloat(), mTickPoints!![0]!!.y.toFloat())
            mTickPath!!.lineTo(stopX, stopY)
            canvas.drawPath(mTickPath!!, mTickPaint!!)

            if (mDrewDistance > mLeftLineDistance) {
                mDrewDistance = mLeftLineDistance
            }
        } else {

            mTickPath!!.moveTo(mTickPoints!![0]!!.x.toFloat(), mTickPoints!![0]!!.y.toFloat())
            mTickPath!!.lineTo(mTickPoints!![1]!!.x.toFloat(), mTickPoints!![1]!!.y.toFloat())
            canvas.drawPath(mTickPath!!, mTickPaint!!)

            // draw right of the tick
            if (mDrewDistance < mLeftLineDistance + mRightLineDistance) {
                val stopX =
                    mTickPoints!![1]!!.x + (mTickPoints!![2]!!.x - mTickPoints!![1]!!.x) * (mDrewDistance - mLeftLineDistance) / mRightLineDistance
                val stopY =
                    mTickPoints!![1]!!.y - (mTickPoints!![1]!!.y - mTickPoints!![2]!!.y) * (mDrewDistance - mLeftLineDistance) / mRightLineDistance

                mTickPath!!.reset()
                mTickPath!!.moveTo(mTickPoints!![1]!!.x.toFloat(), mTickPoints!![1]!!.y.toFloat())
                mTickPath!!.lineTo(stopX, stopY)
                canvas.drawPath(mTickPath!!, mTickPaint!!)

                val step = (if (mWidth / 20 < 3) 3 else mWidth / 20).toFloat()
                mDrewDistance += step
            } else {
                mTickPath!!.reset()
                mTickPath!!.moveTo(mTickPoints!![1]!!.x.toFloat(), mTickPoints!![1]!!.y.toFloat())
                mTickPath!!.lineTo(mTickPoints!![2]!!.x.toFloat(), mTickPoints!![2]!!.y.toFloat())
                canvas.drawPath(mTickPath!!, mTickPaint!!)
            }
        }

        // invalidate
        if (mDrewDistance < mLeftLineDistance + mRightLineDistance) {
            postDelayed(Runnable { postInvalidate() }, 10)
        }
    }

    private fun startCheckedAnimation() {
        val animator = ValueAnimator.ofFloat(1.0f, 0f)
        animator.duration = (mAnimDuration / 3 * 2).toLong()
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { animation ->
            mScaleVal = animation.animatedValue as Float
            floorColor = getGradientColor(unCheckedColor, checkedColor, 1 - mScaleVal)
            postInvalidate()
        }
        animator.start()

        val floorAnimator = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f)
        floorAnimator.duration = mAnimDuration.toLong()
        floorAnimator.interpolator = LinearInterpolator()
        floorAnimator.addUpdateListener { animation ->
            mFloorScale = animation.animatedValue as Float
            postInvalidate()
        }
        floorAnimator.start()

        drawTickDelayed()
    }

    private fun startUnCheckedAnimation() {
        val animator = ValueAnimator.ofFloat(0f, 1.0f)
        animator.duration = mAnimDuration.toLong()
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { animation ->
            mScaleVal = animation.animatedValue as Float
            floorColor = getGradientColor(checkedColor, floorUnCheckedColor, mScaleVal)
            postInvalidate()
        }
        animator.start()

        val floorAnimator = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f)
        floorAnimator.duration = mAnimDuration.toLong()
        floorAnimator.interpolator = LinearInterpolator()
        floorAnimator.addUpdateListener { animation ->
            mFloorScale = animation.animatedValue as Float
            postInvalidate()
        }
        floorAnimator.start()
    }

    private fun drawTickDelayed() {
        postDelayed(Runnable {
            mTickDrawing = true
            postInvalidate()
        }, mAnimDuration.toLong())
    }

    fun setOnCheckedChangeListener(l: OnCheckedChangeListener) {
        this.mListener = l
    }

    interface OnCheckedChangeListener {
        fun onCheckedChanged(checkBox: CustomCheckBox, isChecked: Boolean)
    }

    companion object {

        private val KEY_INSTANCE_STATE = "InstanceState"

        private val COLOR_TICK = Color.WHITE
        private val COLOR_UNCHECKED = Color.WHITE
        private val COLOR_CHECKED = Color.parseColor("#FB4846")
        private val COLOR_FLOOR_UNCHECKED = Color.parseColor("#DFDFDF")

        private val DEF_DRAW_SIZE = 100
        private val DEF_ANIM_DURATION = 300

        private fun getGradientColor(startColor: Int, endColor: Int, percent: Float): Int {
            val startA = Color.alpha(startColor)
            val startR = Color.red(startColor)
            val startG = Color.green(startColor)
            val startB = Color.blue(startColor)

            val endA = Color.alpha(endColor)
            val endR = Color.red(endColor)
            val endG = Color.green(endColor)
            val endB = Color.blue(endColor)

            val currentA = (startA * (1 - percent) + endA * percent).toInt()
            val currentR = (startR * (1 - percent) + endR * percent).toInt()
            val currentG = (startG * (1 - percent) + endG * percent).toInt()
            val currentB = (startB * (1 - percent) + endB * percent).toInt()
            return Color.argb(currentA, currentR, currentG, currentB)
        }

        private fun dp2px(context: Context, dipValue: Float): Int {
            val scale = context.getResources().getDisplayMetrics().density
            return (dipValue * scale + 0.5f).toInt()
        }
    }
}


