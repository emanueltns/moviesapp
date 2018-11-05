package com.devforfun.moviesapp;

import com.devforfun.moviesapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MoviesApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
//        val appComponent = DaggerAppComponent.builder().application(this).build()
//        appComponent.inject(this)
        return DaggerAppComponent.builder().create(this)
    }
}