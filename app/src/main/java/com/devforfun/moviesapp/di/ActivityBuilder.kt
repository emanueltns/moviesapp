package com.devforfun.moviesapp.di

import com.devforfun.moviesapp.ui.MovieDetailActivity
import com.devforfun.moviesapp.ui.MoviesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun moviesActivity(): MoviesActivity

    @ContributesAndroidInjector
    abstract fun movieDetails(): MovieDetailActivity
}