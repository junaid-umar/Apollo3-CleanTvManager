package com.combyne.tvmanager.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.combyne.tvmanager.presentation.ui.home.HomeScreen
import com.combyne.tvmanager.presentation.ui.movie.create_movie.CreateMovieScreen
import com.combyne.tvmanager.presentation.ui.movie.create_movie.CreateMovieViewModel
import com.combyne.tvmanager.presentation.ui.movie.movies.MoviesScreen
import com.combyne.tvmanager.presentation.ui.movie.movies.MoviesViewModel
import com.combyne.tvmanager.presentation.ui.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Screen.Home.route) {

                composable(
                    route = Screen.Home.route,
                ) {
                    HomeScreen(
                        onNavigateToCreateMovie = navController::navigate,
                        onNavigateToMovies = navController::navigate
                    )
                }

                composable(
                    route = Screen.Movies.route
                ) { navBackStackEntry ->

                    val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                    val viewModel: MoviesViewModel =
                        viewModel(key = "MoviesViewModel", factory = factory)

                    MoviesScreen(viewModel = viewModel)
                }

                composable(
                    route = Screen.CreateMovie.route
                ) { navBackStackEntry ->

                    val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                    val viewModel: CreateMovieViewModel =
                        viewModel(key = "CreateMovieViewModel", factory = factory)

                    CreateMovieScreen(viewModel = viewModel)

                }
            }
        }
    }
}