package com.example.dagger.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class UserViewModelFactory @Inject constructor(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserViewModel::class.java))
            UserViewModel(repository) as T
        else
            throw IllegalArgumentException("ViewModel Not Found")
    }
}