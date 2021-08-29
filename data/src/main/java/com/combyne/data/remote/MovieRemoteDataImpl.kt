package com.combyne.data.remote

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloRequest
import com.apollographql.apollo3.cache.normalized.FetchPolicy
import com.apollographql.apollo3.cache.normalized.withFetchPolicy
import com.apollographql.apollo3.exception.ApolloException
import com.combyne.data.CreateMovieMutation
import com.combyne.data.GetMoviesQuery
import com.combyne.data.remote.model.getDataOrNull
import com.combyne.data.remote.util.NetworkUtils.getNetworkErrorMessage
import com.combyne.domain.model.Movie
import com.combyne.domain.usecase.GetMoviesParams
import com.combyne.domain.usecase.SaveMovieParams
import com.combyne.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRemoteDataImpl
@Inject
constructor(
    private val apiClient: ApolloClient,
) : MovieRemoteData {
    override suspend fun getMovies(getMoviesParams: GetMoviesParams): Flow<Result<List<Movie>>> =
        flow {
            try {
                val request =
                    ApolloRequest(GetMoviesQuery()).withFetchPolicy(FetchPolicy.NetworkFirst)
                val response: List<Movie> =
                    apiClient.query(request).dataOrThrow.getDataOrNull()
                emit(Result.Success(response))

            } catch (exception: ApolloException) {
                emit(Result.Error(getNetworkErrorMessage(exception)))
            }
        }


    override suspend fun saveMovie(saveMovieParams: SaveMovieParams): Flow<Result<Unit>> = flow {
        try {
            apiClient.mutate(CreateMovieMutation(title = saveMovieParams.title,
                date = saveMovieParams.releaseDate,
                season = saveMovieParams.season?.toDouble())).dataOrThrow

            emit(Result.Success(Unit))
        } catch (exception: ApolloException) {
            emit(Result.Error(getNetworkErrorMessage(exception)))
        }
    }
}
