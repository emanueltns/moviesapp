package com.devforfun.moviesapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.devforfun.moviesapp.api.model.Movie
import com.devforfun.moviesapp.R
import com.devforfun.moviesapp.schedulers.SchedulerProvider
import com.devforfun.moviesapp.api.MoviesApi
import com.devforfun.moviesapp.databinding.MoviesActivityBinding
import com.devforfun.moviesapp.utils.MoviesViewModelFactory
import com.devforfun.moviesapp.viewmodel.MoviesViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import dagger.internal.Beta
import kotlinx.android.synthetic.main.movies_activity.*
import javax.inject.Inject

class MoviesActivity : DaggerAppCompatActivity() {

    lateinit var adapter: MoviesAdapter
    @Inject
    lateinit var schedulerProvider: SchedulerProvider

    @Inject
    lateinit var moviesApi : MoviesApi

    lateinit var viewModel: MoviesViewModel
    lateinit var binding : MoviesActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity)
        binding  = DataBindingUtil.setContentView(this, R.layout.movies_activity)

//        //init view model
        viewModel = ViewModelProviders
                .of(this, MoviesViewModelFactory(schedulerProvider, moviesApi))
                .get(MoviesViewModel::class.java)
        viewModel.init()
        subscribeLiveObjects()
        binding.moviesList.layoutManager = GridLayoutManager(this,2)
    }

    private fun subscribeLiveObjects() {
        viewModel.moviesSuccess.observe(this, Observer { it ->
            it?.let {
                progress_circular.visibility = View.GONE
                //update adapter
                adapter = MoviesAdapter(it.results) { movie: Movie -> movieItemClicked(movie) }
                binding.moviesList.adapter = adapter
            }
        })
        viewModel.moviesError.observe(this, Observer { it ->
            it?.let {
                Toast.makeText(this,it, Toast.LENGTH_LONG).show()
                progress_circular.visibility = View.GONE
            }
        })
    }

    private fun movieItemClicked(movie: Movie) {
        Toast.makeText(this, "Clicked: ${movie.title}", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MovieDetailActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}
