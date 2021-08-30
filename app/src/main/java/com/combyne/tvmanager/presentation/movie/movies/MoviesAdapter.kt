package com.combyne.tvmanager.presentation.movie.movies

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.combyne.domain.model.Movie
import com.combyne.tvmanager.R
import com.combyne.tvmanager.databinding.ListMovieBinding

class MoviesAdapter :
    ListAdapter<Movie, MoviesAdapter.MovieHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.movieId == newItem.movieId
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(
            androidx.databinding.DataBindingUtil.inflate(
                android.view.LayoutInflater.from(parent.context),
                R.layout.list_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MovieHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = currentList.size


    inner class MovieHolder(private val binding: ListMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }


}