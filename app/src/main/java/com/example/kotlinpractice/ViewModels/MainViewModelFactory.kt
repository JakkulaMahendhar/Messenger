package com.example.kotlinpractice

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val context: Context,private val userEntity: UserEntity,private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {

    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(context,userEntity,application) as T
    }
}