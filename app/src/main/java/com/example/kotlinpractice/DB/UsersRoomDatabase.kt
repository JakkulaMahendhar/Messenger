package com.androidarchitecture.learn.noteapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlinpractice.UserEntity
import com.example.kotlinpractice.UsermasterDao
import java.lang.Exception

@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class UsersRoomDatabase : RoomDatabase() {

    abstract fun usermasterDao(): UsermasterDao

    companion object {

        @Volatile
        private var noteRoomInstance: UsersRoomDatabase? = null

        internal fun getDatabase(context: Context): UsersRoomDatabase? {
            try {
                if (noteRoomInstance == null) {
                    synchronized(UsersRoomDatabase::class.java) {
                        if (noteRoomInstance == null) {
                            noteRoomInstance = Room.databaseBuilder(
                                context.applicationContext,
                                UsersRoomDatabase::class.java, "User_Database"
                            )
                                .build()
                        }
                    }
                }

            } catch (e: Exception) {
                e.message
            }
            return noteRoomInstance
        }
    }
}
