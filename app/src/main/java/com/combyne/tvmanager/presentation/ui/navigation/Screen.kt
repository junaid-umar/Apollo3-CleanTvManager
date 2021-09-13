package com.combyne.tvmanager.presentation.ui.navigation

sealed class Screen(
    val route: String,
) {
    object Home : Screen("home")
    object Movies : Screen("movies")
    object CreateMovie : Screen("createMovie")
}