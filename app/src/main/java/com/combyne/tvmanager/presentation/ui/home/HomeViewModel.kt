package com.combyne.tvmanager.presentation.ui.home

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.combyne.tvmanager.presentation.ui.navigation.MovieNavigation

class HomeViewModel : ViewModel() {

    // add loading/ error here

    fun navigateToCreateMovie(view: View) {
        Log.d("TAG", "navigateToCreateMovie:onCreate ")
        MovieNavigation.navigateToCreateMovie(view)
    }

    fun navigateToMovies(view: View) {
        Log.d("TAG", "navigateToMoviesCreateMovie:onCreate ")
        MovieNavigation.navigateToMovies(view)
    }
}