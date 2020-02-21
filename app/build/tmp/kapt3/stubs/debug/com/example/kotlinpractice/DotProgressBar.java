package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0002\'(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\tH\u0016J\u0006\u0010%\u001a\u00020 J\u0006\u0010&\u001a\u00020 R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/example/kotlinpractice/DotProgressBar;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationDuration", "", "animators", "", "Landroid/animation/Animator;", "dotAnimator", "Landroid/animation/ValueAnimator;", "dotBackground", "dotProgressBar", "Landroid/widget/LinearLayout;", "dotRadius", "margin", "maxScale", "", "minScale", "numberOfDots", "primaryAnimator", "getScaleAnimator", "view", "Landroid/view/View;", "init", "", "isAnimationRunning", "", "setVisibility", "visibility", "startAnimation", "stopAnimation", "Builder", "Companion", "app_debug"})
public final class DotProgressBar extends android.widget.FrameLayout {
    private int margin;
    private int dotRadius;
    private int numberOfDots;
    private final java.util.List<android.animation.Animator> animators = null;
    private long animationDuration;
    private float minScale;
    private float maxScale;
    private android.animation.ValueAnimator primaryAnimator;
    private android.widget.LinearLayout dotProgressBar;
    private int dotBackground;
    private android.animation.ValueAnimator dotAnimator;
    public static final com.example.kotlinpractice.DotProgressBar.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final void init() {
    }
    
    private final android.animation.Animator getScaleAnimator(android.view.View view) {
        return null;
    }
    
    public final void stopAnimation() {
    }
    
    public final void startAnimation() {
    }
    
    public final boolean isAnimationRunning() {
        return false;
    }
    
    @java.lang.Override()
    public void setVisibility(int visibility) {
    }
    
    public DotProgressBar(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    public DotProgressBar(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public DotProgressBar(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/kotlinpractice/DotProgressBar$Builder;", "", "()V", "animationDuration", "", "dotBackground", "", "dotRadius", "margin", "maxScale", "", "minScale", "numberOfDots", "primaryAnimator", "Landroid/animation/ValueAnimator;", "build", "Lcom/example/kotlinpractice/DotProgressBar;", "context", "Landroid/content/Context;", "setAnimationDuration", "duration", "setDotBackground", "setMargin", "setMaxScale", "setMinScale", "setNumberOfDots", "setdotRadius", "app_debug"})
    public static final class Builder {
        private int margin;
        private int dotRadius;
        private int numberOfDots;
        private long animationDuration;
        private float minScale;
        private float maxScale;
        private android.animation.ValueAnimator primaryAnimator;
        private int dotBackground;
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar build(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar.Builder setMargin(int margin) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar.Builder setdotRadius(int dotRadius) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar.Builder setNumberOfDots(int numberOfDots) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar.Builder setMaxScale(float maxScale) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar.Builder setMinScale(float minScale) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar.Builder setAnimationDuration(long duration) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.DotProgressBar.Builder setDotBackground(int dotBackground) {
            return null;
        }
        
        public Builder() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/example/kotlinpractice/DotProgressBar$Companion;", "", "()V", "convertDpToPixel", "", "dp", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        public final int convertDpToPixel(float dp, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return 0;
        }
        
        private Companion() {
            super();
        }
    }
}