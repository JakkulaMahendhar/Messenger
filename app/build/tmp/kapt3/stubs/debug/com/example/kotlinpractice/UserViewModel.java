package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u000256B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\"H\u0002J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005H\u0007J\b\u0010,\u001a\u00020*H\u0014J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020*J\u0006\u00101\u001a\u00020*J \u00102\u001a\u0002032\u0006\u0010\'\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000bH\u0002R\u0014\u0010\n\u001a\u00020\u000bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/example/kotlinpractice/UserViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "context", "Landroid/content/Context;", "userDAO", "Lcom/example/kotlinpractice/UserEntity;", "application", "Landroid/app/Application;", "(Landroid/content/Context;Lcom/example/kotlinpractice/UserEntity;Landroid/app/Application;)V", "(Landroid/app/Application;)V", "NUMBER_OF_ITERATIONS", "", "getNUMBER_OF_ITERATIONS", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "userDo1", "getUserDo1", "()Lcom/example/kotlinpractice/UserEntity;", "setUserDo1", "(Lcom/example/kotlinpractice/UserEntity;)V", "usermasterdao", "Lcom/example/kotlinpractice/UsermasterDao;", "userroomdb", "Lcom/androidarchitecture/learn/noteapplication/UsersRoomDatabase;", "convertFromHex", "", "hexString", "convertToHex", "bytes", "generatePasswordHash", "password", "iterations", "insert", "", "users", "onCleared", "onLoginClick", "view", "Landroid/view/View;", "onMobileVerification", "onSkipClick", "validatePassword", "", "hashedPassword", "InsertAsyncTask", "OperationsAsyncTask", "app_debug"})
public final class UserViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.Nullable()
    private com.example.kotlinpractice.UserEntity userDo1;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context context;
    private com.example.kotlinpractice.UsermasterDao usermasterdao;
    private com.androidarchitecture.learn.noteapplication.UsersRoomDatabase userroomdb;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String TAG;
    private final int NUMBER_OF_ITERATIONS = 5000;
    
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
    
    public final int getNUMBER_OF_ITERATIONS() {
        return 0;
    }
    
    public final void onLoginClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final java.lang.String generatePasswordHash(java.lang.String password, int iterations) throws java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException {
        return null;
    }
    
    private final java.lang.String convertToHex(byte[] bytes) {
        return null;
    }
    
    private final boolean validatePassword(java.lang.String password, java.lang.String hashedPassword, int iterations) throws java.security.NoSuchAlgorithmException, java.security.spec.InvalidKeySpecException {
        return false;
    }
    
    private final byte[] convertFromHex(java.lang.String hexString) {
        return null;
    }
    
    public final void onSkipClick() {
    }
    
    public final void onMobileVerification() {
    }
    
    @android.annotation.SuppressLint(value = {"NewApi"})
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.UserEntity users) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.example.kotlinpractice.UserEntity userDAO, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.CUPCAKE)
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0093\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\r\"\u00020\u0002H\u0014\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/example/kotlinpractice/UserViewModel$OperationsAsyncTask;", "Landroid/os/AsyncTask;", "Lcom/example/kotlinpractice/UserEntity;", "Ljava/lang/Void;", "mAsyncTaskDao", "Lcom/example/kotlinpractice/UsermasterDao;", "(Lcom/example/kotlinpractice/UserViewModel;Lcom/example/kotlinpractice/UsermasterDao;)V", "getMAsyncTaskDao$app_debug", "()Lcom/example/kotlinpractice/UsermasterDao;", "setMAsyncTaskDao$app_debug", "(Lcom/example/kotlinpractice/UsermasterDao;)V", "doInBackground", "notes", "", "([Lcom/example/kotlinpractice/UserEntity;)Ljava/lang/Void;", "app_debug"})
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
    
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0014\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/kotlinpractice/UserViewModel$InsertAsyncTask;", "Lcom/example/kotlinpractice/UserViewModel$OperationsAsyncTask;", "Lcom/example/kotlinpractice/UserViewModel;", "mNoteDao", "Lcom/example/kotlinpractice/UsermasterDao;", "(Lcom/example/kotlinpractice/UserViewModel;Lcom/example/kotlinpractice/UsermasterDao;)V", "doInBackground", "Ljava/lang/Void;", "usersdata", "", "Lcom/example/kotlinpractice/UserEntity;", "([Lcom/example/kotlinpractice/UserEntity;)Ljava/lang/Void;", "app_debug"})
    final class InsertAsyncTask extends com.example.kotlinpractice.UserViewModel.OperationsAsyncTask {
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        protected java.lang.Void doInBackground(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UserEntity... usersdata) {
            return null;
        }
        
        public InsertAsyncTask(@org.jetbrains.annotations.NotNull()
        com.example.kotlinpractice.UsermasterDao mNoteDao) {
            super(null);
        }
    }
}