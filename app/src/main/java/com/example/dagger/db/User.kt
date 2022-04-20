package com.example.dagger.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) @NotNull val uid: Int,
    val name: String,
    val emailId: String,
    val password: String
)
