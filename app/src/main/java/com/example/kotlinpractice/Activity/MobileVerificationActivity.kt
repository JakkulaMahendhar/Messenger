package com.example.kotlinpractice

import android.app.Dialog
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_mobile_verification.*
import com.google.android.gms.tasks.TaskExecutors


import java.util.concurrent.TimeUnit

import com.google.firebase.FirebaseException

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.dialog_otp.*
import kotlinx.android.synthetic.main.mobile_verification_latest.*


class MobileVerificationActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var dialog: Dialog
    private lateinit var progressDialog: ProgressDialog

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

    private fun showOTPDialog() {
        dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_otp)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.show()

        startTimer(30)

        dialog.buttonConfirm.setOnClickListener {
            if (!dialog.editTextOTP.text.toString().isEmpty()) {
                //Tools.visibleViews(dialog.progressBarConfirm)
                //Tools.disableViews(dialog.buttonConfirm, dialog.editTextOTP)
                val otp = dialog.editTextOTP.text.toString()
                //confirm check
                if (otp.equals("123456")) {
                    dialog.dismiss()
                    goToHomeScreen()
                } else {
                    // The verification code entered was invalid
                    dialog.editTextOTP.error = "Invalid Code"
                    //Tools.inVisibleViews(dialog.progressBarConfirm, type = 1)
                    //Tools.enableViews(dialog.buttonConfirm, dialog.editTextOTP)
                }

            } else {
                dialog.editTextOTP.error = "Length must be 6"
            }

        }
        dialog.textResendCode.setOnClickListener {
            // mToast.showToast(this, "Resending", Toast.LENGTH_SHORT)
            //resendVerificationCode(editTextMobNumber.text.toString())
        }
    }

    private fun startTimer(second: Long) {
        object : CountDownTimer(second * 1000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                //Tools.visibleViews(dialog.textTimer, dialog.progressBarTimer)
                //Tools.disableViews(dialog.textResendCode)
                dialog.textTimer.text = (millisUntilFinished / 1000).toString()
            }


            override fun onFinish() {
                dialog.textResendCode.setTextColor(resources.getColor(R.color.colorPrimaryDark))
//                Tools.inVisibleViews(dialog.textTimer, dialog.progressBarTimer, type = 0)
//                Tools.enableViews(dialog.textResendCode)
            }

        }.start()
    }

    private fun goToHomeScreen() {
        val intent = Intent(MobileVerificationActivity@ this, HomeActivity::class.java)
        startActivity(intent)
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

                if (tv_mobile.text.toString().trim().length == 10) {
                    showOTPDialog()
                    //editTextCode.visibility = View.VISIBLE
                    sendVerificationCode(tv_mobile.text.toString())
                    //btn_continue.visibility = View.GONE
                    //dotProgressBar?.startAnimation()
                    progressbar?.visibility = View.VISIBLE
                } else {
                    tv_mobile.error = "Mobile Number must be 10 digits"
                }

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
