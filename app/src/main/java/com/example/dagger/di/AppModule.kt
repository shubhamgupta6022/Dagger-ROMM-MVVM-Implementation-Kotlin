package com.example.dagger.di

import android.content.Context
import androidx.room.Room
import com.example.dagger.db.UserDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideDb(context: Context): UserDb {
        return Room.databaseBuilder(context, UserDb::class.java, "db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(db: UserDb) = db.userDao()
}