package com.example.kotlinpractice

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.firebase.auth.FirebaseAuth


class SplashScreenActivity : AppCompatActivity() {

    //Google Login Request Code
    private val RC_SIGN_IN = 7
    //Google Sign In Client
    //private lateinit var mGoogleSignInClient: GoogleSignIN
    //Firebase Auth
    private lateinit var mAuth: FirebaseAuth

    private val MY_PERMISSION_REQUEST_CODE = 100


    var permissions = arrayOf<String>(
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.CAMERA
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_latest)
        checkPermissions()
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

    fun checkPermissions() {
        try {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permissions[0]
                ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                    this,
                    permissions[1]
                ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                    this,
                    permissions[2]
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, permissions, MY_PERMISSION_REQUEST_CODE)
            }
        } catch (e: Exception) {
            // Utils.logMsg("MainActivity.checkPermissions()" + e.message)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSION_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, " permissions granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, " permissions denied", Toast.LENGTH_LONG).show()
            }
        }
    }


}
