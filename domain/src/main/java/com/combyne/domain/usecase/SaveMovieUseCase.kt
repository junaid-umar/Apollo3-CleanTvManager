package com.combyne.domain.usecase

import com.combyne.domain.model.Movie
import com.combyne.domain.repository.MovieRepository
import com.combyne.domain.usecase.base.FlowUseCase
import com.combyne.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime
import javax.inject.Inject

data class SaveMovieParams(
    val title: String,
    val releaseDate: ZonedDateTime?,
    val season: Int?,
)

class SaveMovieUseCase
@Inject constructor(
    private val movieRepository: MovieRepository,
    dispatcher: CoroutineDispatcher,
) : FlowUseCase<SaveMovieParams, Movie>(dispatcher) {
    override suspend fun execute(parameters: SaveMovieParams): Flow<Result<Movie>> {
        return movieRepository.saveMovie(parameters)
    }
}