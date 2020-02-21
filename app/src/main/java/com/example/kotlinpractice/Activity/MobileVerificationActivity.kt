package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_mobile_verification.*
import com.google.android.gms.tasks.TaskExecutors


import java.util.concurrent.TimeUnit

import com.google.firebase.FirebaseException

import android.content.Intent
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.mobile_verification_latest.*


class MobileVerificationActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var frameLayout: RelativeLayout
    var mVerificationId: String? = null

    //firebase auth object
    private var mAuth: FirebaseAuth? = null

    var dotProgressBar: DotProgressBar? = null
    private var cancel: Drawable? = null
    var phone: Drawable? = null

    var progressbar: ProgressBar? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.mobile_verification_latest)
            getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
            mAuth = FirebaseAuth.getInstance()
            //frameLayout = findViewById(R.id.relativelayout)

            init()
            tv_mobile.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    charSequence: CharSequence,
                    i: Int,
                    i1: Int,
                    i2: Int
                ) {

                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    if (charSequence.length > 0)
                        tv_mobile.setCompoundDrawables(phone, null, cancel, null)
                    else
                        tv_mobile.setCompoundDrawables(phone, null, null, null)
                }

                override fun afterTextChanged(editable: Editable) {

                }
            })

            tv_mobile.setDrawableClickListener(object : DrawableClickListener {
                override fun onClick(target: DrawableClickListener.DrawablePosition) {
                    when (target) {
                        DrawableClickListener.DrawablePosition.RIGHT ->
                            removeAllThings()
                    }
                }
            })

//       dotProgressBar = DotProgressBar.Builder()
//            .setMargin(4)
//            .setAnimationDuration(2000)
//            .setDotBackground(R.drawable.ic_launcher_background)
//            .setMaxScale(1f)
//            .setMinScale(0.3f)
//            .setNumberOfDots(5)
//            .setdotRadius(8)
//            .build(this)
//        frameLayout.addView(dotProgressBar)
            //dotProgressBar.startAnimation()
            progressbar?.visibility = View.GONE

//            btn_continue.setOnClickListener(this)
//            btn_signin.setOnClickListener(this)

            btn_get_otp.setOnClickListener(this)

        } catch (e: Exception) {
            e.message
        }
    }

    private fun removeAllThings() {
        tv_mobile.setText(null)
    }

    private fun init() {
        try {

            phone = ContextCompat.getDrawable(this, R.drawable.ic_icons8_cell_phone_100);
            if (phone != null)
                phone!!.setBounds(0, 0, 48, 48);
            tv_mobile.setCompoundDrawables(phone, null, null, null);

            cancel = ContextCompat.getDrawable(this, R.drawable.icon_cancel);
            if (cancel != null)
                cancel!!.setBounds(0, 0, 36, 36);
            /* tv_email.setCompoundDrawables(mail, null, cancel, null);*/
        } catch (e: java.lang.Exception) {
            e.message
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.btn_get_otp -> {

                //editTextCode.visibility = View.VISIBLE
                sendVerificationCode(tv_mobile.text.toString())
                //btn_continue.visibility = View.GONE
                //dotProgressBar?.startAnimation()
                progressbar?.visibility = View.VISIBLE
            }
            R.id.btn_signin -> {
                val code = editTextCode.text.toString().trim()
                if (code.isEmpty() || code.length < 6) {
                    editTextCode.error = "Enter valid code"
                    editTextCode.requestFocus()
                    return
                }
                progressbar?.visibility = View.VISIBLE
                verifyVerificationCode(code)
            }

        }
    }

    private fun sendVerificationCode(mobile: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            "+91$mobile",
            60,
            TimeUnit.SECONDS,
            TaskExecutors.MAIN_THREAD,
            mCallbacks
        )
    }


    //the callback to detect the verification status
    private val mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {

            //Getting the code sent by SMS
            val code = phoneAuthCredential.smsCode

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                editTextCode.setText(code)
                //verifying the code
                verifyVerificationCode(code)
            }
        }

        override fun onVerificationFailed(e: FirebaseException) {
            // Toast.makeText(this@VerifyPhoneActivity, e.message, Toast.LENGTH_LONG).show()
        }

        override fun onCodeSent(
            s: String,
            forceResendingToken: PhoneAuthProvider.ForceResendingToken
        ) {
            super.onCodeSent(s, forceResendingToken)

            //storing the verification id that is sent to the user
            mVerificationId = s
        }
    }

    private fun verifyVerificationCode(code: String) {
        //creating the credential
        val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)

        //signing the user
        signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth?.signInWithCredential(credential)
            ?.addOnCompleteListener(this@MobileVerificationActivity,
                OnCompleteListener<AuthResult> { task ->
                    progressbar?.visibility = View.GONE
                    if (task.isSuccessful) {
                        //verification successful we will start the profile activity
                        dotProgressBar?.stopAnimation()
                        val intent =
                            Intent(this@MobileVerificationActivity, MainActivity::class.java)
                        intent.flags =
                            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)

                    } else {

                        //verification unsuccessful.. display an error message

                        var message = "Somthing is wrong, we will fix it soon..."

                        if (task.exception is FirebaseAuthInvalidCredentialsException) {
                            message = "Invalid code entered..."
                        }

//                            val snackbar =
//                                Snackbar.make(findViewById(R.id.frameLayout), message, Snackbar.LENGTH_LONG)
//                            snackbar.setAction("Dismiss") { }
//                            snackbar.show()
                    }
                })
    }

}
