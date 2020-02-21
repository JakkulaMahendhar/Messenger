package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/kotlinpractice/DrawableClickListener;", "", "onClick", "", "target", "Lcom/example/kotlinpractice/DrawableClickListener$DrawablePosition;", "DrawablePosition", "app_debug"})
public abstract interface DrawableClickListener {
    
    public abstract void onClick(@org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.DrawableClickListener.DrawablePosition target);
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/kotlinpractice/DrawableClickListener$DrawablePosition;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "LEFT", "RIGHT", "app_debug"})
    public static enum DrawablePosition {
        /*public static final*/ TOP /* = new TOP() */,
        /*public static final*/ BOTTOM /* = new BOTTOM() */,
        /*public static final*/ LEFT /* = new LEFT() */,
        /*public static final*/ RIGHT /* = new RIGHT() */;
        
        DrawablePosition() {
        }
    }
}