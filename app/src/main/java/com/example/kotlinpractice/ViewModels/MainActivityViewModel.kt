package com.example.kotlinpractice

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.androidarchitecture.learn.noteapplication.UsersRoomDatabase

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    var userDo1: UserEntity? = null
    var context: Context? = null

    var TAG: String = MainActivityViewModel::class.java.simpleName

    private var usermasterdao: UsermasterDao? = null
    private var userroomdb: UsersRoomDatabase? = null

    init {
        Log.d(TAG, "View Model Created")
        userroomdb = UsersRoomDatabase.getDatabase(application)
        usermasterdao = userroomdb!!.usermasterDao()
    }


    constructor(
        context: Context,
        userDAO: UserEntity,
        application: Application
    ) : this(application = Application()) {
        this.context = context
        this.userDo1 = userDAO
    }

    fun editClick() {

        userDo1 = UserEntity("", "", "")

    }

    fun signOutClick() {
        val intent = Intent(context, SplashScreenActivity::class.java)
        context?.startActivity(intent)
    }


    fun update(user: UserEntity) {
        UpdateAsyncTask(usermasterdao!!).execute(user)
    }

    private inner class UpdateAsyncTask internal constructor(noteDao: UsermasterDao) :
        OperationsAsyncTask(noteDao) {

        protected override fun doInBackground(vararg notes: UserEntity): Void? {
            mAsyncTaskDao.update(notes[0])
            return null
        }
    }

    @SuppressLint("StaticFieldLeak")
    private open inner class OperationsAsyncTask internal constructor(internal var mAsyncTaskDao: UsermasterDao) :
        AsyncTask<UserEntity, Void, Void>() {

        override fun doInBackground(vararg notes: UserEntity): Void? {
            return null
        }
    }
}