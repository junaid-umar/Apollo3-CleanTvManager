package com.combyne.data.repository

import com.combyne.data.remote.MovieRemoteData
import com.combyne.domain.model.Movie
import com.combyne.domain.repository.MovieRepository
import com.combyne.domain.usecase.GetMoviesParams
import com.combyne.domain.usecase.SaveMovieParams
import com.combyne.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl
@Inject
constructor(
    private val movieRemoteData: MovieRemoteData,
) : MovieRepository {
    override fun getMovies(getMoviesParams: GetMoviesParams): Flow<Result<List<Movie>>> =
        flow {
            emit(Result.Loading())
            movieRemoteData.getMovies(getMoviesParams).collect {
                emit(it)
            }

        }

    override fun saveMovie(saveMovieParams: SaveMovieParams): Flow<Result<Unit>> =
        flow {
            emit(Result.Loading())
            movieRemoteData.saveMovie(saveMovieParams).collect {
                emit(it)
            }

        }
}