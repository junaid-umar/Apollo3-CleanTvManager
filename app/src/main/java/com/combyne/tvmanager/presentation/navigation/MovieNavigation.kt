package com.combyne.tvmanager.presentation.navigation

import android.view.View
import androidx.navigation.findNavController
import com.combyne.tvmanager.presentation.home.HomeFragmentDirections

object MovieNavigation {

    fun navigateToCreateMovie(view: View) {
        val action = HomeFragmentDirections.actionHomeToCreateMovie()
        view.findNavController().navigate(action)
    }

    fun navigateToMovies(view: View) {
        val action = HomeFragmentDirections.actionHomeToMovies()
        view.findNavController().navigate(action)
    }
}