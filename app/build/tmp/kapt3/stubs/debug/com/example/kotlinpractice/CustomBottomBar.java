package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\nJ\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/kotlinpractice/CustomBottomBar;", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "bottomItemClickInterface", "Lcom/example/kotlinpractice/BottomBarAdapter$BottomItemClickInterface;", "(Landroid/view/View;Landroid/content/Context;Lcom/example/kotlinpractice/BottomBarAdapter$BottomItemClickInterface;)V", "ITEM_LIMIT", "", "bottomItems", "Ljava/util/ArrayList;", "Lcom/example/kotlinpractice/BottomItem;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "addBottomItem", "", "item", "apply", "selected", "calculateItemWidth", "setAdapter", "setType", "app_debug"})
public final class CustomBottomBar {
    private final int ITEM_LIMIT = 5;
    private android.content.Context context;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private java.util.ArrayList<com.example.kotlinpractice.BottomItem> bottomItems;
    private com.example.kotlinpractice.BottomBarAdapter.BottomItemClickInterface bottomItemClickInterface;
    
    private final void setType(android.view.View view) {
    }
    
    public final void addBottomItem(@org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.BottomItem item) {
    }
    
    private final void setAdapter(int selected) {
    }
    
    private final int calculateItemWidth() {
        return 0;
    }
    
    public final void apply(int selected) {
    }
    
    public CustomBottomBar(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.BottomBarAdapter.BottomItemClickInterface bottomItemClickInterface) {
        super();
    }
}