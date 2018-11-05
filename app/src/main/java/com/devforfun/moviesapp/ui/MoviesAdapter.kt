package com.devforfun.moviesapp.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.devforfun.moviesapp.R
import com.devforfun.moviesapp.api.model.Movie
import com.devforfun.moviesapp.utils.inflate
import com.devforfun.moviesapp.utils.loadUrl
import kotlinx.android.synthetic.main.movies_item.view.*

class MoviesAdapter(private val movies : List<Movie>, private val clickListener: (Movie) -> Unit)
    : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.movies_item))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies.get(position), clickListener)
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val image: ImageView = itemView.card_view.image
    val title : TextView = itemView.card_view.movie_title

    fun bind(movie: Movie, clickListener : (Movie) -> Unit) {
        title.text = movie.title
        //TODO find out the url called for getting the image
        image.loadUrl(movie.posterPath)
        itemView.setOnClickListener{clickListener(movie)}
    }
}