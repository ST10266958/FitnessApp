package com.andisa.fitnessapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.andisa.fitnessapp.data.dao.CategoryDao
import com.andisa.fitnessapp.data.dao.UserDao
import com.andisa.fitnessapp.data.dao.WorkoutDao
import com.andisa.fitnessapp.data.entity.Category
import com.andisa.fitnessapp.data.entity.User
import com.andisa.fitnessapp.data.entity.Workout

@Database(
    entities = [
        User::class,
        Category::class,
        Workout::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun categoryDao(): CategoryDao

    abstract fun workoutDao(): WorkoutDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "sportsync_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}