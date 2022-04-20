package com.example.dagger.di

import android.content.Context
import com.example.dagger.MainActivity
import com.example.dagger.RegisterActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: RegisterActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}