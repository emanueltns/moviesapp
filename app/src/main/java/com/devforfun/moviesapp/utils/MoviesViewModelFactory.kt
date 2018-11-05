package com.devforfun.moviesapp.utils;

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.devforfun.moviesapp.schedulers.BaseSchedulerProvider
import com.devforfun.moviesapp.api.MoviesApi
import com.devforfun.moviesapp.viewmodel.MoviesViewModel


class MoviesViewModelFactory(private var schedulerProvider: BaseSchedulerProvider,
                             private var api: MoviesApi) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoviesViewModel(schedulerProvider, api) as T
    }
}