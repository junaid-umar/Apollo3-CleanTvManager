package com.combyne.domain.model

import java.time.ZonedDateTime

data class Movie(
    val movieId: String,
    // For Coil Demo
    val movieCover: String? = "https://maxcdn.icons8.com/app/uploads/2019/05/film-poster-graphic-design.jpg",
    val title: String,
    val releaseData: ZonedDateTime?,
    val seasons: Int?,
)