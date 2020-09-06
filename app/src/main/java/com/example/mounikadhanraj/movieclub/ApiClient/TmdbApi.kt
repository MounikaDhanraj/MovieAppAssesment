package com.example.mounikadhanraj.movieclub.ApiClien
import com.example.mounikadhanraj.movieclub.Data.TmdbMovieResponse
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {

    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<TmdbMovieResponse>>


}