package com.example.mounikadhanraj.movieclub


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mounikadhanraj.movieclub.ApiClient.ApiFactory
import com.example.mounikadhanraj.movieclub.Data.TmdbMoviePopularResult
import com.example.mounikadhanraj.movieclub.ui.MovieAdapter
import com.example.mounikadhanraj.movieclub.ui.MovieDetailsActivity
import com.example.mounikadhanraj.movieclub.ui.OnItemClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var adapter: MovieAdapter
    private lateinit var movieListRecyclerView: RecyclerView
    private val MovieList = ArrayList<TmdbMoviePopularResult>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTitle("TMDB MOVIE ")
        movieListRecyclerView = findViewById(R.id.Movie_list)
        movieListRecyclerView.setHasFixedSize(false)
        movieListRecyclerView.layoutManager = GridLayoutManager(
            this, 3,
            GridLayoutManager.VERTICAL, false
        )

        GlobalScope.launch(Dispatchers.Main) {

            val movieService = ApiFactory.tmdbApi
            val popularMovieRequest = movieService.getPopularMovie()
            val response = popularMovieRequest.await()

            if (response.isSuccessful) {
                val movieResponse = response.body()
                movieResponse?.toString()?.let { Log.d("MainActivity", it) }
                if (movieResponse?.results != null) {
                    getPopularMovies(movieResponse.results)
                }

            }
        }

    }


    fun getPopularMovies(response: ArrayList<TmdbMoviePopularResult>) {
        MovieList.addAll(response)
        adapter = MovieAdapter(MovieList, this)
        movieListRecyclerView.adapter = adapter
    }
    override fun onItemClicked(movie: TmdbMoviePopularResult, position: Int) {
            if (movie != null) {
                startActivity(MovieDetailsActivity.createIntent(this, movie))

            }
        }

}

    // TODO: LOAD MORE Pages

