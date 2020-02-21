package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0002`aB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tB\'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010A\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010B\u001a\u00020=H\u0002J\u0010\u0010C\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\u0012\u0010D\u001a\u00020=2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010E\u001a\u00020\u0018H\u0016J\u0010\u0010F\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0014J0\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH\u0014J\u0018\u0010M\u001a\u00020=2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\bH\u0014J\u0010\u0010P\u001a\u00020=2\u0006\u0010Q\u001a\u00020RH\u0014J\b\u0010S\u001a\u00020RH\u0014J\b\u0010T\u001a\u00020=H\u0002J\u0010\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020\u0018H\u0016J\u0016\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020\u00182\u0006\u0010W\u001a\u00020\u0018J\u000e\u0010X\u001a\u00020=2\u0006\u0010Y\u001a\u00020\'J\b\u0010Z\u001a\u00020=H\u0002J\b\u0010[\u001a\u00020=H\u0002J\b\u0010\\\u001a\u00020=H\u0016J\u0015\u0010]\u001a\u00020!*\u00020!2\u0006\u0010^\u001a\u00020_H\u0082\u0002R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e02X\u0082.\u00a2\u0006\u0004\n\u0002\u00103R\u000e\u00104\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b7\u0010\u000e\"\u0004\b8\u0010\u0010R\u001a\u00109\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000e\"\u0004\b;\u0010\u0010\u00a8\u0006b"}, d2 = {"Lcom/example/kotlinpractice/CustomCheckBox;", "Landroid/view/View;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "checkedColor", "getCheckedColor", "()I", "setCheckedColor", "(I)V", "floorColor", "getFloorColor", "setFloorColor", "floorUnCheckedColor", "getFloorUnCheckedColor", "setFloorUnCheckedColor", "isSmallTick", "", "()Z", "setSmallTick", "(Z)V", "mAnimDuration", "mCenterPoint", "Landroid/graphics/Point;", "mChecked", "mDrewDistance", "", "mFloorPaint", "Landroid/graphics/Paint;", "mFloorScale", "mLeftLineDistance", "mListener", "Lcom/example/kotlinpractice/CustomCheckBox$OnCheckedChangeListener;", "mPaint", "mRightLineDistance", "mScaleVal", "mStrokeWidth", "mTickColor", "mTickDrawing", "mTickPaint", "mTickPath", "Landroid/graphics/Path;", "mTickPoints", "", "[Landroid/graphics/Point;", "mWidth", "color", "tickColor", "getTickColor", "setTickColor", "unCheckedColor", "getUnCheckedColor", "setUnCheckedColor", "drawBorder", "", "canvas", "Landroid/graphics/Canvas;", "drawCenter", "drawTick", "drawTickDelayed", "drawTickPath", "init", "isChecked", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "reset", "setChecked", "checked", "animate", "setOnCheckedChangeListener", "l", "startCheckedAnimation", "startUnCheckedAnimation", "toggle", "plus", "step", "", "Companion", "OnCheckedChangeListener", "app_debug"})
public final class CustomCheckBox extends android.view.View implements android.widget.Checkable {
    private android.graphics.Paint mPaint;
    private android.graphics.Paint mTickPaint;
    private android.graphics.Paint mFloorPaint;
    private android.graphics.Point[] mTickPoints;
    private android.graphics.Point mCenterPoint;
    private android.graphics.Path mTickPath;
    private float mLeftLineDistance;
    private float mRightLineDistance;
    private float mDrewDistance;
    private float mScaleVal;
    private float mFloorScale;
    private int mWidth;
    private int mAnimDuration;
    private int mStrokeWidth;
    private int mTickColor;
    private int checkedColor;
    private int unCheckedColor;
    private int floorColor;
    private int floorUnCheckedColor;
    private boolean mChecked;
    private boolean mTickDrawing;
    private com.example.kotlinpractice.CustomCheckBox.OnCheckedChangeListener mListener;
    private boolean isSmallTick;
    private static final java.lang.String KEY_INSTANCE_STATE = "InstanceState";
    private static final int COLOR_TICK = android.graphics.Color.WHITE;
    private static final int COLOR_UNCHECKED = android.graphics.Color.WHITE;
    private static final int COLOR_CHECKED = 0;
    private static final int COLOR_FLOOR_UNCHECKED = 0;
    private static final int DEF_DRAW_SIZE = 100;
    private static final int DEF_ANIM_DURATION = 300;
    public static final com.example.kotlinpractice.CustomCheckBox.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public final int getCheckedColor() {
        return 0;
    }
    
    public final void setCheckedColor(int p0) {
    }
    
    public final int getUnCheckedColor() {
        return 0;
    }
    
    public final void setUnCheckedColor(int p0) {
    }
    
    public final int getFloorColor() {
        return 0;
    }
    
    public final void setFloorColor(int p0) {
    }
    
    public final int getFloorUnCheckedColor() {
        return 0;
    }
    
    public final void setFloorUnCheckedColor(int p0) {
    }
    
    public final boolean isSmallTick() {
        return false;
    }
    
    public final void setSmallTick(boolean p0) {
    }
    
    public final int getTickColor() {
        return 0;
    }
    
    public final void setTickColor(int color) {
    }
    
    private final void init(android.util.AttributeSet attrs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.os.Parcelable onSaveInstanceState() {
        return null;
    }
    
    @java.lang.Override()
    protected void onRestoreInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Parcelable state) {
    }
    
    @java.lang.Override()
    public boolean isChecked() {
        return false;
    }
    
    @java.lang.Override()
    public void toggle() {
    }
    
    @java.lang.Override()
    public void setChecked(boolean checked) {
    }
    
    /**
     * checked with animation
     *
     * @param checked checked
     * @param animate change with animation
     */
    public final void setChecked(boolean checked, boolean animate) {
    }
    
    private final void reset() {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    @java.lang.Override()
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    private final void drawCenter(android.graphics.Canvas canvas) {
    }
    
    private final void drawBorder(android.graphics.Canvas canvas) {
    }
    
    private final void drawTick(android.graphics.Canvas canvas) {
    }
    
    private final float plus(float $this$plus, java.lang.Object step) {
        return 0.0F;
    }
    
    private final void drawTickPath(android.graphics.Canvas canvas) {
    }
    
    private final void startCheckedAnimation() {
    }
    
    private final void startUnCheckedAnimation() {
    }
    
    private final void drawTickDelayed() {
    }
    
    public final void setOnCheckedChangeListener(@org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.CustomCheckBox.OnCheckedChangeListener l) {
    }
    
    public CustomCheckBox(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public CustomCheckBox(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public CustomCheckBox(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    public CustomCheckBox(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/kotlinpractice/CustomCheckBox$OnCheckedChangeListener;", "", "onCheckedChanged", "", "checkBox", "Lcom/example/kotlinpractice/CustomCheckBox;", "isChecked", "", "app_debug"})
    public static abstract interface OnCheckedChangeListener {
        
        public abstract void onCheckedChanged(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.CustomCheckBox checkBox, boolean isChecked);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/kotlinpractice/CustomCheckBox$Companion;", "", "()V", "COLOR_CHECKED", "", "COLOR_FLOOR_UNCHECKED", "COLOR_TICK", "COLOR_UNCHECKED", "DEF_ANIM_DURATION", "DEF_DRAW_SIZE", "KEY_INSTANCE_STATE", "", "dp2px", "context", "Landroid/content/Context;", "dipValue", "", "getGradientColor", "startColor", "endColor", "percent", "app_debug"})
    public static final class Companion {
        
        private final int getGradientColor(int startColor, int endColor, float percent) {
            return 0;
        }
        
        private final int dp2px(android.content.Context context, float dipValue) {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}