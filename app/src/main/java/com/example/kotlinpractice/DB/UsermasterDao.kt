package com.example.kotlinpractice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface UsermasterDao {

    @Insert
    fun insert(userEntity: UserEntity)

    @Update
    fun update(userEntity: UserEntity)

}