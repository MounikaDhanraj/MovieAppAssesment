package com.example.mounikadhanraj.movieclub.Data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TmdbMoviePopularResult(
    val poster_path: String = "poster path",
    val adult : Boolean= false,
    val overview :String = "",
    val release_date : String="",
    val genre_ids : List<Int>,
    val id :Int = 0,
    val original_title:String="",
    val original_language : String="",
    val title:String="",
    val backdrop_path:String="",
    val popularity : Number = 0,
    val vote_count : Int=0,
    val video : Boolean=false,
    val vote_average : Number = 0,
) : Parcelable

@Parcelize
data class TmdbMovieResponse (
    var page: Int=0,
    val results: ArrayList<TmdbMoviePopularResult>?,
    var totalResults: Int = 0,
    var totalPages: Int = 0,
):Parcelable



