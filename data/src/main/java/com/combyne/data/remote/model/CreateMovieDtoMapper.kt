package com.combyne.data.remote.model

import com.combyne.data.CreateMovieMutation
import com.combyne.domain.model.Movie
import com.combyne.domain.util.DomainMapper
import com.combyne.domain.util.TimeUtils

class CreateMovieDtoMapper : DomainMapper<CreateMovieMutation.Movie, Movie> {
    override fun toDomainModel(model: CreateMovieMutation.Movie): Movie {
        return Movie(
            movieId = model.id,
            title = model.title,
            releaseData = model.releaseDate?.let { TimeUtils.stringToDate(it as String) },
            seasons = model.seasons?.toInt()
        )
    }

    override fun fromDomainModel(model: Movie): CreateMovieMutation.Movie {
        TODO("not required")
    }
}