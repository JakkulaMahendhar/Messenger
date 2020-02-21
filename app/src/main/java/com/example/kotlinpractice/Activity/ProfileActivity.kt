package com.example.kotlinpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    val NOTE_ID = "note_id"
    internal val UPDATED_NOTE = "note_text"
    private var etNote: EditText? = null
    private var noteId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val userdata = intent.getParcelableExtra("USER_OBJ") as Parcelable
        Log.d("", userdata.toString())

        //etNote?.text = (userdata as UserEntity).email

    }

    fun updateNote(view: View) {
        val updatedNote = etNote?.getText().toString()
        val resultIntent = Intent()
        resultIntent.putExtra(NOTE_ID, noteId)
        resultIntent.putExtra(UPDATED_NOTE, updatedNote)
        setResult(RESULT_OK, resultIntent)
        finish()
    }

    fun cancelUpdate(view: View) {
        finish()
    }
}
