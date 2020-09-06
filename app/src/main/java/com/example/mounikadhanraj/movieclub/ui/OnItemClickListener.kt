package com.example.mounikadhanraj.movieclub.ui

import com.example.mounikadhanraj.movieclub.Data.TmdbMoviePopularResult
import java.text.FieldPosition

interface OnItemClickListener {

    fun onItemClicked(movie: TmdbMoviePopularResult, position: Int)
}