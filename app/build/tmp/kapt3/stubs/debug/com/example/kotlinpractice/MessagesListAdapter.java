package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bB\u0005\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/example/kotlinpractice/MessagesListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/kotlinpractice/MessagesListAdapter$ViewHolder;", "context", "Landroid/content/Context;", "userlist", "Ljava/util/ArrayList;", "Lcom/example/kotlinpractice/UsersMessageModel;", "Lkotlin/collections/ArrayList;", "itemClick", "Lcom/example/kotlinpractice/OnItemClickListener;", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/example/kotlinpractice/OnItemClickListener;)V", "()V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "itemClickListener", "getItemClickListener", "()Lcom/example/kotlinpractice/OnItemClickListener;", "setItemClickListener", "(Lcom/example/kotlinpractice/OnItemClickListener;)V", "getUserlist", "()Ljava/util/ArrayList;", "setUserlist", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class MessagesListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.kotlinpractice.MessagesListAdapter.ViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private android.content.Context context;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.example.kotlinpractice.UsersMessageModel> userlist;
    @org.jetbrains.annotations.Nullable()
    private com.example.kotlinpractice.OnItemClickListener itemClickListener;
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.example.kotlinpractice.UsersMessageModel> getUserlist() {
        return null;
    }
    
    public final void setUserlist(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.example.kotlinpractice.UsersMessageModel> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.kotlinpractice.OnItemClickListener getItemClickListener() {
        return null;
    }
    
    public final void setItemClickListener(@org.jetbrains.annotations.Nullable()
    com.example.kotlinpractice.OnItemClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.kotlinpractice.MessagesListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.MessagesListAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public MessagesListAdapter() {
        super();
    }
    
    public MessagesListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.kotlinpractice.UsersMessageModel> userlist, @org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.OnItemClickListener itemClick) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/kotlinpractice/MessagesListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindItems", "", "context", "Landroid/content/Context;", "user", "Lcom/example/kotlinpractice/UsersMessageModel;", "itemClickListener", "Lcom/example/kotlinpractice/OnItemClickListener;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public final void bindItems(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UsersMessageModel user, @org.jetbrains.annotations.Nullable()
        com.example.kotlinpractice.OnItemClickListener itemClickListener) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}