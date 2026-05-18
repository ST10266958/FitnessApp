package com.andisa.fitnessapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andisa.fitnessapp.data.entity.User
class UserDao {

    @Insert
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    suspend fun loginUser(email: String, password: String): User?
}