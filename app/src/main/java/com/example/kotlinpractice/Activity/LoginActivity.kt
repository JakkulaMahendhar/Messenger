package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinpractice.databinding.ActivityLoginBinding
import mvvm.livedata.example.viewmodel.factory.UserViewModelFactory
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.Exception
import android.text.Editable
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.text.method.HideReturnsTransformationMethod


class LoginActivity : AppCompatActivity() {

    private var cancel: Drawable? = null
    var mail: Drawable? = null
    var view: Drawable? = null
    var notView: Drawable? = null
    var password: Drawable? = null
    var isNotViewEnabled: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        init()

        tv_email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0)
                    tv_email.setCompoundDrawables(mail, null, cancel, null)
                else
                    tv_email.setCompoundDrawables(mail, null, null, null)
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })

        tv_password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.length > 0)
                    tv_password.setCompoundDrawables(password, null, view, null)
                else
                    tv_password.setCompoundDrawables(password, null, null, null)
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })

        tv_password.setDrawableClickListener(object : DrawableClickListener {
            override fun onClick(target: DrawableClickListener.DrawablePosition) {
                when (target) {
                    DrawableClickListener.DrawablePosition.RIGHT -> if (isNotViewEnabled) {
                        isNotViewEnabled = false
                        tv_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                        tv_password.setCompoundDrawables(password, null, notView, null)
                    } else {
                        isNotViewEnabled = true
                        tv_password.setTransformationMethod(PasswordTransformationMethod.getInstance())
                        tv_password.setCompoundDrawables(password, null, view, null)
                    }
                }
            }
        })

        tv_email.setDrawableClickListener(object : DrawableClickListener {
            override fun onClick(target: DrawableClickListener.DrawablePosition) {
                when (target) {
                    DrawableClickListener.DrawablePosition.RIGHT ->
                        removeAllThings()
                }
            }
        })

        val userViewModel =
            ViewModelProviders.of(
                this,
                UserViewModelFactory(this, UserEntity("", "", ""), application)
            )
                .get(UserViewModel::class.java)


        binding.userviewmodel = userViewModel
    }

    private fun removeAllThings() {
        tv_email.setText(null)
        tv_password.setText(null)
        tv_password.setTransformationMethod(PasswordTransformationMethod.getInstance())
        tv_password.setCompoundDrawables(password, null, null, null)
        tv_email.setEnabled(true)
        tv_email.setFocusable(true)
        tv_email.setFocusableInTouchMode(true)
        isNotViewEnabled = false
//            inputLayout.setVisibility(View.GONE)
//            txtForgotPwd.setVisibility(View.GONE)
//            btnSignIn.setVisibility(View.VISIBLE)
//            btnSignUp.setVisibility(View.INVISIBLE)
//            btnSignIn.setEnabled(false)
//            btnSignIn.setBackground(getDrawable(R.drawable.bg_btn_disable))
        tv_email.setCompoundDrawables(mail, null, null, null)
    }

    private fun init() {
        try {

            view = ContextCompat.getDrawable(this, R.drawable.icon_view);
            if (view != null)
                view!!.setBounds(0, 0, 36, 36);

            notView = ContextCompat.getDrawable(this, R.drawable.icon_not_view);
            if (notView != null)
                notView!!.setBounds(0, 0, 36, 36);

            mail = ContextCompat.getDrawable(this, R.drawable.icon_mail);
            if (mail != null)
                mail!!.setBounds(0, 0, 48, 48);
            tv_email.setCompoundDrawables(mail, null, null, null);

            password = ContextCompat.getDrawable(this, R.drawable.icon_pwd);
            if (password != null)
                password!!.setBounds(0, 0, 48, 48);
            tv_password.setCompoundDrawables(password, null, null, null);

            cancel = ContextCompat.getDrawable(this, R.drawable.icon_cancel);
            if (cancel != null)
                cancel!!.setBounds(0, 0, 36, 36);
            /* tv_email.setCompoundDrawables(mail, null, cancel, null);*/
        } catch (e: Exception) {
            e.message
        }
    }
}
