package com.example.kotlinpractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020(H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00067"}, d2 = {"Lcom/example/kotlinpractice/MobileVerificationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "cancel", "Landroid/graphics/drawable/Drawable;", "dotProgressBar", "Lcom/example/kotlinpractice/DotProgressBar;", "getDotProgressBar", "()Lcom/example/kotlinpractice/DotProgressBar;", "setDotProgressBar", "(Lcom/example/kotlinpractice/DotProgressBar;)V", "frameLayout", "Landroid/widget/RelativeLayout;", "getFrameLayout", "()Landroid/widget/RelativeLayout;", "setFrameLayout", "(Landroid/widget/RelativeLayout;)V", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mCallbacks", "Lcom/google/firebase/auth/PhoneAuthProvider$OnVerificationStateChangedCallbacks;", "mVerificationId", "", "getMVerificationId", "()Ljava/lang/String;", "setMVerificationId", "(Ljava/lang/String;)V", "phone", "getPhone", "()Landroid/graphics/drawable/Drawable;", "setPhone", "(Landroid/graphics/drawable/Drawable;)V", "progressbar", "Landroid/widget/ProgressBar;", "getProgressbar", "()Landroid/widget/ProgressBar;", "setProgressbar", "(Landroid/widget/ProgressBar;)V", "init", "", "onClick", "p0", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "removeAllThings", "sendVerificationCode", "mobile", "signInWithPhoneAuthCredential", "credential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "verifyVerificationCode", "code", "app_debug"})
public final class MobileVerificationActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    public android.widget.RelativeLayout frameLayout;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String mVerificationId;
    private com.google.firebase.auth.FirebaseAuth mAuth;
    @org.jetbrains.annotations.Nullable()
    private com.example.kotlinpractice.DotProgressBar dotProgressBar;
    private android.graphics.drawable.Drawable cancel;
    @org.jetbrains.annotations.Nullable()
    private android.graphics.drawable.Drawable phone;
    @org.jetbrains.annotations.Nullable()
    private android.widget.ProgressBar progressbar;
    private final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RelativeLayout getFrameLayout() {
        return null;
    }
    
    public final void setFrameLayout(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMVerificationId() {
        return null;
    }
    
    public final void setMVerificationId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.kotlinpractice.DotProgressBar getDotProgressBar() {
        return null;
    }
    
    public final void setDotProgressBar(@org.jetbrains.annotations.Nullable()
    com.example.kotlinpractice.DotProgressBar p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getPhone() {
        return null;
    }
    
    public final void setPhone(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.widget.ProgressBar getProgressbar() {
        return null;
    }
    
    public final void setProgressbar(@org.jetbrains.annotations.Nullable()
    android.widget.ProgressBar p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void removeAllThings() {
    }
    
    private final void init() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    private final void sendVerificationCode(java.lang.String mobile) {
    }
    
    private final void verifyVerificationCode(java.lang.String code) {
    }
    
    private final void signInWithPhoneAuthCredential(com.google.firebase.auth.PhoneAuthCredential credential) {
    }
    
    public MobileVerificationActivity() {
        super();
    }
}