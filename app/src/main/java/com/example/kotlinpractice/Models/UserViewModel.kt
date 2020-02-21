package com.example.kotlinpractice

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.androidarchitecture.learn.noteapplication.UsersRoomDatabase
import java.math.BigInteger
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidKeySpecException
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import kotlin.experimental.xor

class UserViewModel(application: Application) : AndroidViewModel(application) {

    var userDo1: UserEntity? = null
    var context: Context? = null

    private var usermasterdao: UsermasterDao? = null
    private var userroomdb: UsersRoomDatabase? = null

    var TAG: String = UserViewModel::class.java.simpleName

    val NUMBER_OF_ITERATIONS = 5000

    init {
        Log.d(TAG, "View Model Created")
        userroomdb = UsersRoomDatabase.getDatabase(application)
        usermasterdao = userroomdb!!.usermasterDao()
    }

    constructor(
        context: Context,
        userDAO: UserEntity,
        application: Application
    ) : this(application) {
        this.userDo1 = userDAO
        this.context = context

    }

    fun onLoginClick(view: View) {
        val email = userDo1?.email
        val password = userDo1?.password
        if (email.equals("")) {
            Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show()
        }
        if (password.equals("")) {
            Toast.makeText(context, "Invalid Password", Toast.LENGTH_SHORT).show()
        } else {
            val note_id = UUID.randomUUID().toString()
            var passwordHash = generatePasswordHash(password.toString(), NUMBER_OF_ITERATIONS)
            userDo1 = UserEntity(note_id, email.toString(), passwordHash);
            insert(userDo1!!)
            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "Login Successful")
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("USER_OBJ", userDo1)
            context?.startActivity(intent)
            (context as Activity).finish()
        }

        Log.d(TAG, userDo1.toString())
    }

    @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
    private fun generatePasswordHash(password: String, iterations: Int): String {
        val keyLength = 512
        val charArray = password.toCharArray()

        val random = SecureRandom.getInstance("SHA1PRNG")
        // a salt is a random sequence of bytes that is attached to our
        // password to make the hash more secure
        val salt = ByteArray(16)
        random.nextBytes(salt)

        val pbeks = PBEKeySpec(charArray, salt, iterations, keyLength)
        val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        val hash = skf.generateSecret(pbeks).encoded

        return convertToHex(salt) + "-" + convertToHex(hash)
    }

    private fun convertToHex(bytes: ByteArray): String {
        val integer = BigInteger(1, bytes)
        val hex = integer.toString(16)
        val paddingLength = bytes.size * 2 - hex.length

        return if (paddingLength > 0) String.format("%0" + paddingLength + "d", 0) + hex else hex
    }

    @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
    private fun validatePassword(
        password: String,
        hashedPassword: String,
        iterations: Int
    ): Boolean {
        val parts =
            hashedPassword.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val salt = convertFromHex(parts[0])
        val hash = convertFromHex(parts[1])

        val pbeks = PBEKeySpec(password.toCharArray(), salt, iterations, hash.size * 8)
        val skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        val testHash = skf.generateSecret(pbeks).encoded

        var diff = hash.size xor testHash.size
        var i = 0
        while (i < hash.size && i < testHash.size) {
            diff = diff or ((hash[i] xor testHash[i]).toInt())
            i++
        }
        return diff == 0
    }

    // this function takes the string in hex format and converts it to bytes
    private fun convertFromHex(hexString: String): ByteArray {
        val bytes = ByteArray(hexString.length / 2)
        for (i in bytes.indices) {
            bytes[i] = Integer.parseInt(hexString.substring(2 * i, 2 * i + 2), 16).toByte()
        }
        return bytes
    }

    fun onSkipClick() {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context?.startActivity(intent)
        (context as Activity).finish()
    }

    fun onMobileVerification() {
        val intent = Intent(context, MobileVerificationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context?.startActivity(intent)
    }

    @SuppressLint("NewApi")
    fun insert(users: UserEntity) {
        InsertAsyncTask(usermasterdao!!).execute(users)
    }

    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @SuppressLint("StaticFieldLeak")
    private open inner class OperationsAsyncTask internal constructor(internal var mAsyncTaskDao: UsermasterDao) :
        AsyncTask<UserEntity, Void, Void>() {

        override fun doInBackground(vararg notes: UserEntity): Void? {
            return null
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class InsertAsyncTask internal constructor(mNoteDao: UsermasterDao) :
        OperationsAsyncTask(mNoteDao) {

        override fun doInBackground(vararg usersdata: UserEntity): Void? {
            mAsyncTaskDao.insert(usersdata[0])
            Log.d(TAG, "User data inserted")
            return null
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "View Model Destroyed")
    }
}