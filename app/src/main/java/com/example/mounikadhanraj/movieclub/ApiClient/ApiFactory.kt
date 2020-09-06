package com.example.mounikadhanraj.movieclub.ApiClient

import com.example.mounikadhanraj.movieclub.ApiClien.TmdbApi
import com.example.mounikadhanraj.movieclub.AppConstants

object ApiFactory{

    /*val placeholderApi : PlaceholderApi = RetrofitFactory.retrofit(AppConstants.JSON_PLACEHOLDER_BASE_URL)
        .create(PlaceholderApi::class.java)*/
    val tmdbApi : TmdbApi = RetrofitFactory.retrofit(AppConstants.TMDB_BASE_URL)
        .create(TmdbApi::class.java)
}