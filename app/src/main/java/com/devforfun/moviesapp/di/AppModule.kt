package com.devforfun.moviesapp.di;

import android.content.Context
import com.devforfun.moviesapp.MoviesApplication
import com.devforfun.moviesapp.schedulers.BaseSchedulerProvider
import com.devforfun.moviesapp.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(NetworkModule::class))
class AppModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        internal fun providesScheduler(scheduler : SchedulerProvider)
                : BaseSchedulerProvider {
            return SchedulerProvider()
        }
    }

    @Provides
    fun providesContext(application: MoviesApplication): Context {
        return application.applicationContext
    }

//    @Binds
//    @Singleton
//    fun provideScheduler(scheduler : SchedulerProvider): BaseSchedulerProvider
}