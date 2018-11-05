package com.devforfun.moviesapp.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.devforfun.moviesapp.schedulers.BaseSchedulerProvider
import com.devforfun.moviesapp.BuildConfig
import com.devforfun.moviesapp.api.MoviesApi
import com.devforfun.moviesapp.api.model.MoviesResponse
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

class MoviesViewModel (val schedulerProvider: BaseSchedulerProvider,
                       val moviesApi: MoviesApi) : ViewModel() {

    internal val moviesSuccess = MutableLiveData<MoviesResponse>()
    internal val moviesError = MutableLiveData<String>()
    private val subscriptions = CompositeDisposable()

    fun init() {
        getMovies()
    }

    fun getMovies() {
        subscriptions.add(moviesApi.dicoverMovies(BuildConfig.API_KEY,"1")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    moviesSuccess.postValue(it)
                }, {
                    moviesError.postValue(it.message)
                }, { Timber.d("Chains Completed")}
                ))
    }

    fun clear() {
        subscriptions.clear()
    }
}