package com.example.dagger

import android.app.Application
import com.example.dagger.di.ApplicationComponent
import com.example.dagger.di.DaggerApplicationComponent

class MyApplication : Application() {
    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.factory().create(this)

    }
}