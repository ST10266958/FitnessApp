package com.andisa.fitnessapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "workouts",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Workout(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,

    val categoryId: Int,

    val goal: String,

    val duration: String,

    val sets: Int,

    val reps: Int,

    val notes: String,

    val date: String
)