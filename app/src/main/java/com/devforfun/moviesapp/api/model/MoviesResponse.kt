package com.devforfun.moviesapp.api.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(@SerializedName("page") val page : Int,
                          @SerializedName("total_results") val totalResults : Int,
                          @SerializedName("total_pages") val totalPages : Int,
                          @SerializedName("results") val results : List<Movie>)

class Movie(@SerializedName("vote_count") val voteCount : Int,
            @SerializedName("id") val id : Int,
            @SerializedName("video") val video : Boolean,
            @SerializedName("vote_average") val voteAverage : Double,
            @SerializedName("title") val title : String?,
            @SerializedName("popularity") val popularity : Double,
            @SerializedName("poster_path") val posterPath : String?,
            @SerializedName("original_language") val originalLanguage : String?,
            @SerializedName("original_title") val originalTitle : String?,
            @SerializedName("genre_ids") val genreIds : List<Int>?,
            @SerializedName("backdrop_path") val backDropPath : String?,
            @SerializedName("adult") val adult : Boolean,
            @SerializedName("overview") val overview : String,
            @SerializedName("releaseDate") val releaseDate : String)