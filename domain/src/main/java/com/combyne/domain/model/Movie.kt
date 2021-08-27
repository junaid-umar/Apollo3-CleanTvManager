package com.combyne.domain.model

import java.time.ZonedDateTime

data class Movie(
    val movieId: String,
    val title: String,
    val releaseData: ZonedDateTime?,
    val seasons: Int?,
)