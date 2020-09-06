package com.example.mounikadhanraj.movieclub.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mounikadhanraj.movieclub.AppConstants
import com.example.mounikadhanraj.movieclub.AppConstants.TMDB_PHOTO_URL
import com.example.mounikadhanraj.movieclub.Data.TmdbMoviePopularResult
import com.example.mounikadhanraj.movieclub.MainActivity
import com.example.mounikadhanraj.movieclub.R
import com.squareup.picasso.Picasso

class MovieAdapter(
    val movies: MutableList<TmdbMoviePopularResult>,
    val onItemClickListener: MainActivity,
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

        companion object {

            fun getCompleteUrl(path: String): String
            {
                    return TMDB_PHOTO_URL + AppConstants.POSTERS_W_500 + path
                }
            }


          override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
          {

            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
            return ViewHolder(view)
          }

        override fun getItemCount(): Int
        {
                return movies.size
        }

    fun addMovies(nextMoviesList: MutableList<TmdbMoviePopularResult>) {
        movies.addAll(nextMoviesList)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.name.text = movie.title
        Picasso.get().load(getCompleteUrl(movie.poster_path)).
            centerInside().fit().
        into(holder.icon)

        holder.itemView.setOnClickListener { onItemClickListener.onItemClicked(movie,position) }

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView= itemView.findViewById(R.id.icon) as ImageView
        val name: TextView=itemView.findViewById(R.id.title) as TextView
    }

}