package com.example.kotlinpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth

class SplashScreenActivity : AppCompatActivity() {

    //Google Login Request Code
    private val RC_SIGN_IN = 7
    //Google Sign In Client
    //private lateinit var mGoogleSignInClient: GoogleSignIN
    //Firebase Auth
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_latest)
    }

    //    fun emailLoginVerification(view: View) {
//
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
//    }
//
    fun mobileLoginVerification(view: View) {
        val intent = Intent(this, MobileVerificationActivity::class.java)
        startActivity(intent)
    }


    fun facebookLoginVerification(view: View) {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


}
