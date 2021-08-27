package com.combyne.domain.usecase

import com.combyne.domain.repository.MovieRepository
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetMoviesUseCaseTest {

    @RelaxedMockK
    lateinit var movieRepository: MovieRepository

    private lateinit var getMoviesUseCase: GetMoviesUseCase
    private lateinit var moviesParams: GetMoviesParams

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        moviesParams = GetMoviesParams(
            1
        )
        getMoviesUseCase = GetMoviesUseCase(movieRepository, TestCoroutineDispatcher())
    }

    @Test
    fun saveMovie() = runBlockingTest {
        getMoviesUseCase.invoke(
            moviesParams
        )
        coVerify {
            movieRepository.getMovies(moviesParams)
        }
    }

}