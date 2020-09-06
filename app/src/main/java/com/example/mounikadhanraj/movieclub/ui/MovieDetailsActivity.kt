package com.example.mounikadhanraj.movieclub.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mounikadhanraj.movieclub.Data.TmdbMoviePopularResult
import com.example.mounikadhanraj.movieclub.R
import com.squareup.picasso.Picasso


class MovieDetailsActivity: AppCompatActivity() {

        companion object {
            private val EXTRA_SELECTED_MOVIE ="selected_movie"
            fun createIntent(context: Context, movie: TmdbMoviePopularResult): Intent {

                val intent = Intent(context, MovieDetailsActivity::class.java)

                intent.putExtra(EXTRA_SELECTED_MOVIE, movie)
                return intent
            }
        }
            override fun onCreate(savedInstanceState: Bundle?)
            {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.movie_details_activity)

               val movie : TmdbMoviePopularResult =
                intent.getParcelableExtra<TmdbMoviePopularResult>(EXTRA_SELECTED_MOVIE) as TmdbMoviePopularResult

                    val image = findViewById<ImageView>(R.id.poster)
                    val title: TextView = findViewById<TextView>(R.id.title)
                    title.setText(movie.title)
                    Picasso.get()
                        .load(MovieAdapter.getCompleteUrl(movie.poster_path))
                        .into(image)

                    val overview: TextView = findViewById<TextView>(R.id.title)
                    overview.setText(movie.overview)
                }

                //TODO: Move this code to fragment
                /*val frag = MovieDetailsFragment.newInstance(movie)
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, frag)
                    .commit()*/

    }


