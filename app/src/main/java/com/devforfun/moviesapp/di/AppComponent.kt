package com.devforfun.moviesapp.di;

import com.devforfun.moviesapp.MoviesApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@ApplicationScope
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        AppModule::class, ActivityBuilder::class))
interface AppComponent : AndroidInjector<MoviesApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MoviesApplication>()
}