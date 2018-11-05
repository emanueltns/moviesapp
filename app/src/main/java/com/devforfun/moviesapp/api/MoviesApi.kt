package com.devforfun.moviesapp.api;

import com.devforfun.moviesapp.api.model.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/3/movie/popular")
    fun dicoverMovies(@Query("api_key") apiKey: String,
                      @Query("page") pageNumber : String) : Observable<MoviesResponse>
}