package com.devforfun.moviesapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movies_item.view.*

class MoviesAdapter(val context : Context, val clickListener: (Movie) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    var items : ArrayList<Movie> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movies_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position), clickListener)
    }

    fun update(items : ArrayList<Movie>) {
        this.items = items;
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val image: ImageView = itemView.card_view.image
    val title : TextView = itemView.card_view.movie_title

    fun bind(movie: Movie, clickListener : (Movie) -> Unit) {
        title.text =movie.title
        val picasso  = Picasso.get()
        picasso.isLoggingEnabled = true
        picasso.load(movie.imageUrl)
                .into(image)
        itemView.setOnClickListener{clickListener(movie)}
    }
}