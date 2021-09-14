package com.combyne.tvmanager.presentation.ui.movie.create_movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.combyne.domain.util.Result
import com.combyne.tvmanager.presentation.components.CircularProgressBar
import com.combyne.tvmanager.presentation.components.CreateMovie
import com.combyne.tvmanager.presentation.components.DefaultSnackBar

@Composable
fun CreateMovieScreen(
    viewModel: CreateMovieViewModel,
) {

    val title = viewModel.title.value
    val releaseDate = viewModel.releaseDate.value
    val season = viewModel.season.value
    val movie = viewModel.movie.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(

        scaffoldState = scaffoldState,
        snackbarHost = {
            scaffoldState.snackbarHostState
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.surface)
        ) {

            CreateMovie(
                title,
                releaseDate,
                season,
                viewModel::setTitle,
                viewModel::setReleaseDate,
                viewModel::setSeason,
                modifier = Modifier.fillMaxSize(),
                viewModel::saveMovie
            )
            // Move to AppTheme
            if (movie is Result.Loading) {
                CircularProgressBar(isLoading = true)
            }
            if (movie is Result.Error) {
                LaunchedEffect(movie) {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = movie.error
                    )
                }
                DefaultSnackBar(
                    snackbarHostState = scaffoldState.snackbarHostState,
                    modifier = Modifier.align(Alignment.BottomCenter)) {

                }

            }
        }
    }

}