package com.example.dagger.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao

//    companion object {
//        private var INSTANCE: UserDb? = null
//
//        fun getInstance(context: Context): UserDb {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    UserDb::class.java,
//                    "db"
//                )
//                    .fallbackToDestructiveMigration()
//                    .build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }
}