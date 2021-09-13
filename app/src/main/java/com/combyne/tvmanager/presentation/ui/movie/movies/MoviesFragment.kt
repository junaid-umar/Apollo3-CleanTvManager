package com.combyne.tvmanager.presentation.ui.movie.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalFocusManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.annotation.ExperimentalCoilApi
import com.combyne.domain.util.Result
import com.combyne.tvmanager.presentation.components.CircularProgressBar
import com.combyne.tvmanager.presentation.components.DefaultSnackBar
import com.combyne.tvmanager.presentation.components.Movies
import com.combyne.tvmanager.presentation.components.SearchAppBar
import com.combyne.tvmanager.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalCoilApi
class MoviesFragment : Fragment() {
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme(darkTheme = false) {
                    val movies = viewModel.movies.value
                    val query = viewModel.query.value
                    val focusManager = LocalFocusManager.current
                    val scaffoldState = rememberScaffoldState()

                    Scaffold(
                        topBar = {
                            SearchAppBar(query = query,
                                onQueryChanged = viewModel::onQueryChanged,
                                focusManager = focusManager)
                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = MaterialTheme.colors.surface)
                        ) {
                            if (movies is Result.Success) {
                                Movies(movies = movies.data, onClick = {})
                            }
                            if (movies is Result.Loading) {
                                CircularProgressBar(isLoading = true)
                            }
                            if (movies is Result.Error) {
                                LaunchedEffect(movies) {
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        message = movies.error
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
            }
        }
    }

}


