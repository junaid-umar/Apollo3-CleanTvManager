package com.combyne.data.remote.model

import com.combyne.data.GetMoviesQuery
import com.combyne.domain.model.Movie
import com.combyne.domain.util.DomainMapper
import com.combyne.domain.util.TimeUtils

class NodeDtoMapper : DomainMapper<GetMoviesQuery.Node, Movie> {
    override fun toDomainModel(model: GetMoviesQuery.Node): Movie {
        return Movie(
            movieId = model.id,
            title = model.title,
            releaseData = model.releaseDate?.let { TimeUtils.stringToDate(it as String) },
            seasons = model.seasons?.toInt(),
        )
    }

    override fun fromDomainModel(model: Movie): GetMoviesQuery.Node {
        TODO("Not required")
    }
}

fun GetMoviesQuery.Data.getDataOrNull(): List<Movie> {
    return this.movies.edges?.mapNotNull {
        it?.node?.let {
            NodeDtoMapper().toDomainModel(it)
        }
    } ?: emptyList()
}