package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\"#B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0005R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/kotlinpractice/MainActivityViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/content/Context;", "userDAO", "Lcom/example/kotlinpractice/UserEntity;", "application", "Landroid/app/Application;", "(Landroid/content/Context;Lcom/example/kotlinpractice/UserEntity;Landroid/app/Application;)V", "(Landroid/app/Application;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "userDo1", "getUserDo1", "()Lcom/example/kotlinpractice/UserEntity;", "setUserDo1", "(Lcom/example/kotlinpractice/UserEntity;)V", "usermasterdao", "Lcom/example/kotlinpractice/UsermasterDao;", "userroomdb", "Lcom/androidarchitecture/learn/noteapplication/UsersRoomDatabase;", "editClick", "", "signOutClick", "update", "user", "OperationsAsyncTask", "UpdateAsyncTask", "app_debug"})
public final class MainActivityViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.Nullable()
    private com.example.kotlinpractice.UserEntity userDo1;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String TAG;
    private com.example.kotlinpractice.UsermasterDao usermasterdao;
    private com.androidarchitecture.learn.noteapplication.UsersRoomDatabase userroomdb;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.kotlinpractice.UserEntity getUserDo1() {
        return null;
    }
    
    public final void setUserDo1(@org.jetbrains.annotations.Nullable()
    com.example.kotlinpractice.UserEntity p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void setTAG(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final void editClick() {
    }
    
    public final void signOutClick() {
    }
    
    public final void update(@org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.UserEntity user) {
    }
    
    public MainActivityViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    public MainActivityViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.UserEntity userDAO, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0014\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/kotlinpractice/MainActivityViewModel$UpdateAsyncTask;", "Lcom/example/kotlinpractice/MainActivityViewModel$OperationsAsyncTask;", "Lcom/example/kotlinpractice/MainActivityViewModel;", "noteDao", "Lcom/example/kotlinpractice/UsermasterDao;", "(Lcom/example/kotlinpractice/MainActivityViewModel;Lcom/example/kotlinpractice/UsermasterDao;)V", "doInBackground", "Ljava/lang/Void;", "notes", "", "Lcom/example/kotlinpractice/UserEntity;", "([Lcom/example/kotlinpractice/UserEntity;)Ljava/lang/Void;", "app_debug"})
    final class UpdateAsyncTask extends com.example.kotlinpractice.MainActivityViewModel.OperationsAsyncTask {
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UserEntity... notes) {
            return null;
        }
        
        public UpdateAsyncTask(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UsermasterDao noteDao) {
            super(null);
        }
    }
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0093\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/example/kotlinpractice/MainActivityViewModel$OperationsAsyncTask;", "Landroid/os/AsyncTask;", "Lcom/example/kotlinpractice/UserEntity;", "Ljava/lang/Void;", "mAsyncTaskDao", "Lcom/example/kotlinpractice/UsermasterDao;", "(Lcom/example/kotlinpractice/MainActivityViewModel;Lcom/example/kotlinpractice/UsermasterDao;)V", "getMAsyncTaskDao$app_debug", "()Lcom/example/kotlinpractice/UsermasterDao;", "setMAsyncTaskDao$app_debug", "(Lcom/example/kotlinpractice/UsermasterDao;)V", "doInBackground", "notes", "", "([Lcom/example/kotlinpractice/UserEntity;)Ljava/lang/Void;", "app_debug"})
    class OperationsAsyncTask extends android.os.AsyncTask<com.example.kotlinpractice.UserEntity, java.lang.Void, java.lang.Void> {
        @org.jetbrains.annotations.NotNull()
        private com.example.kotlinpractice.UsermasterDao mAsyncTaskDao;
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UserEntity... notes) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.kotlinpractice.UsermasterDao getMAsyncTaskDao$app_debug() {
            return null;
        }
        
        public final void setMAsyncTaskDao$app_debug(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UsermasterDao p0) {
        }
        
        public OperationsAsyncTask(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UsermasterDao mAsyncTaskDao) {
            super();
        }
    }
}