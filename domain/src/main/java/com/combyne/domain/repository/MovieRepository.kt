package com.combyne.domain.repository

import com.combyne.domain.model.Movie
import com.combyne.domain.usecase.GetMoviesParams
import com.combyne.domain.usecase.SaveMovieParams
import com.combyne.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
     fun getMovies(getMoviesParams: GetMoviesParams): Flow<Result<List<Movie>>>

     fun saveMovie(saveMovieParams: SaveMovieParams): Flow<Result<Unit>>
}