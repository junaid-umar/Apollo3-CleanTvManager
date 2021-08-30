package com.combyne.data.repository

import app.cash.turbine.test
import com.combyne.data.remote.MovieRemoteData
import com.combyne.domain.usecase.GetMoviesParams
import com.combyne.domain.usecase.SaveMovieParams
import com.combyne.domain.util.Result
import com.combyne.domain.util.TimeUtils
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime
@ExperimentalTime
@ExperimentalCoroutinesApi
class MovieRepositoryImplTest {


    @RelaxedMockK
    lateinit var movieRemoteData: MovieRemoteData

    private lateinit var movieRepository: MovieRepositoryImpl

    private lateinit var saveMovieParams: SaveMovieParams
    private lateinit var moviesParams: GetMoviesParams

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        saveMovieParams = SaveMovieParams(
            "test title",
            TimeUtils.stringToDate("2021-08-11T22:00:00.000Z"),
            1
        )

        moviesParams = GetMoviesParams(
            1
        )

        movieRepository = MovieRepositoryImpl(movieRemoteData)
    }

    @Test
    fun getMovies() = runBlockingTest {
        movieRepository.getMovies(moviesParams).test{
            assertThat(awaitItem()).isInstanceOf(Result.Loading::class.java)
            coVerify {
                movieRemoteData.getMovies(moviesParams)
            }
            cancelAndConsumeRemainingEvents()
        }
    }

    @Test
    fun saveMovie() = runBlockingTest {
        movieRepository.saveMovie(saveMovieParams).test{
            assertThat(awaitItem()).isInstanceOf(Result.Loading::class.java)
            coVerify {
                movieRemoteData.saveMovie(saveMovieParams)
            }
            cancelAndConsumeRemainingEvents()
        }
    }
}
