package com.combyne.data

import com.combyne.domain.model.Movie
import com.combyne.domain.util.TimeUtils

object FakeDataUtil {


    object Domain {
        val movie1 = Movie(
            movieId = "test1",
            title = "title1",
            releaseData = TimeUtils.stringToDate("2021-08-11T22:00:00.000Z"),
            seasons = 1
        )
        val movie2 = Movie(
            movieId = "test2",
            title = "title2",
            releaseData = TimeUtils.stringToDate("2021-08-11T22:00:00.000Z"),
            seasons = 2
        )
        val movies = listOf(movie1, movie2)
    }

    object Data {
        val movie1 = CreateMovieMutation.Movie(
            id = "test1",
            title = "title1",
            releaseDate = "2021-08-11T22:00:00.000Z",
            seasons = 1.0
        )

        val movie2 = CreateMovieMutation.Movie(
            id = "test2",
            title = "title2",
            releaseDate = "2021-08-11T22:00:00.000Z",
            seasons = 2.0
        )
        val movies = listOf(Domain.movie1, Domain.movie2)


        val node1 = GetMoviesQuery.Node(
            id = "test1",
            title = "title1",
            releaseDate = "2021-08-11T22:00:00.000Z",
            seasons = 1.0
        )
        val node2 = GetMoviesQuery.Node(
            id = "test2",
            title = "title2",
            releaseDate = "2021-08-11T22:00:00.000Z",
            seasons = 2.0
        )

        val nodes = listOf(node1, node2)

        val GetMoviesQueryData: GetMoviesQuery.Data = GetMoviesQuery.Data(
            GetMoviesQuery.Movies(
                listOf(GetMoviesQuery.Edge(node1), GetMoviesQuery.Edge(node2))
            )
        )
        val GetMoviesQueryDataEmpty: GetMoviesQuery.Data = GetMoviesQuery.Data(
            GetMoviesQuery.Movies(listOf())
        )
    }
}