package com.combyne.domain.usecase

import com.combyne.domain.model.Movie
import com.combyne.domain.repository.MovieRepository
import com.combyne.domain.usecase.base.FlowUseCase
import com.combyne.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class GetMoviesParams(
    val page: Int,
)


class GetMoviesUseCase
@Inject constructor(
    private val movieRepository: MovieRepository,
    dispatcher: CoroutineDispatcher,
) : FlowUseCase<GetMoviesParams, List<Movie>>(dispatcher) {
    override fun execute(parameters: GetMoviesParams): Flow<Result<List<Movie>>> {
        return movieRepository.getMovies(parameters)
    }
}