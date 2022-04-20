package com.example.dagger.db

import android.content.Context
import javax.inject.Inject

class UserRepository @Inject constructor(context: Context, db: UserDb) {
    private var userDao: UserDao = db.userDao()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun getUid(email: String, password: String): Int? {
        return userDao.getUid(email, password)
    }

}