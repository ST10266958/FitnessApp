package com.andisa.sportsync.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andisa.fitnessapp.data.entity.Workout

@Dao
interface WorkoutDao {

    @Insert
    suspend fun insertWorkout(workout: Workout)

    @Query("SELECT * FROM workouts")
    suspend fun getAllWorkouts(): List<Workout>

    @Query("SELECT * FROM workouts WHERE categoryId = :categoryId")
    suspend fun getWorkoutsByCategory(categoryId: Int): List<Workout>
}