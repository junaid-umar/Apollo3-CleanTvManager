package com.combyne.domain.usecase

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
){
    companion object Validate{

    }
}

class SaveMovieUseCase
@Inject constructor(
    private val movieRepository: MovieRepository,
    dispatcher: CoroutineDispatcher,
) : FlowUseCase<SaveMovieParams, Unit>(dispatcher) {
    override suspend fun execute(parameters: SaveMovieParams): Flow<Result<Unit>> {
        return movieRepository.saveMovie(parameters)
    }
}