package com.devforfun.moviesapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.movies_activity.*

class MoviesActivity : AppCompatActivity() {

    lateinit var adapter: MoviesAdapter
    val movies : ArrayList<Movie> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movies_activity)
        initMovies()
        movies_list.layoutManager = GridLayoutManager(this,2)
        adapter = MoviesAdapter(this) { movie : Movie -> movieItemClicked(movie)}
        movies_list.adapter = adapter
        adapter.update(movies)
    }

    private fun initMovies() {
        progress_circular.visibility = View.GONE
        for (i in 1..30)
            movies.add(Movie("Title "+i, "https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png"))
    }

    private fun movieItemClicked(movie: Movie) {
        Toast.makeText(this, "Clicked: ${movie.title}", Toast.LENGTH_SHORT).show()
    }
}
