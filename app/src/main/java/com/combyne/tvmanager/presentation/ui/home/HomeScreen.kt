package com.combyne.tvmanager.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.combyne.tvmanager.R
import com.combyne.tvmanager.presentation.ui.navigation.Screen

@Composable
fun HomeScreen(
    onNavigateToCreateMovie: (String) -> Unit,
    onNavigateToMovies: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            onNavigateToMovies(Screen.Movies.route)
        }) {
            Text(stringResource(R.string.show_added_movies))
        }
        Button(onClick = { onNavigateToCreateMovie(Screen.CreateMovie.route) }) {
            Text(stringResource(R.string.create_new_movie))
        }
    }
}