package com.combyne.domain.usecase

import com.combyne.domain.repository.MovieRepository
import com.combyne.domain.util.TimeUtils
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class SaveMovieUseCaseTest {

    @RelaxedMockK
    lateinit var movieRepository: MovieRepository

    private lateinit var saveMovieUseCase: SaveMovieUseCase
    private lateinit var saveMovieParams: SaveMovieParams

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        saveMovieParams= SaveMovieParams(
            "test title",
            TimeUtils.stringToDate("2021-08-11T22:00:00.000Z"),
            1
        )
        saveMovieUseCase = SaveMovieUseCase(movieRepository, TestCoroutineDispatcher())
    }

    @Test
    fun saveMovie() = runBlockingTest {
        saveMovieUseCase.invoke(
            saveMovieParams
        )
        coVerify {
            movieRepository.saveMovie(saveMovieParams)
        }
    }

}