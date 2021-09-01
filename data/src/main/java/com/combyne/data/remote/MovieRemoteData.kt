package com.combyne.data.remote

import com.combyne.domain.model.Movie
import com.combyne.domain.usecase.GetMoviesParams
import com.combyne.domain.usecase.SaveMovieParams
import com.combyne.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface MovieRemoteData {
    fun getMovies(getMoviesParams: GetMoviesParams): Flow<Result<List<Movie>>>

    fun saveMovie(saveMovieParams: SaveMovieParams): Flow<Result<Unit>>
}