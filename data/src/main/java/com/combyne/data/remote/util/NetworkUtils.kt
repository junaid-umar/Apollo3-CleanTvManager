package com.combyne.data.remote.util

import com.apollographql.apollo3.exception.ApolloException
import com.apollographql.apollo3.exception.ApolloNetworkException
import com.apollographql.apollo3.exception.ApolloWebSocketClosedException

internal object NetworkUtils {

    const val PAGE_SIZE = 100

    private const val genericNetworkError = "An error occurred getting data from server."

    fun getNetworkErrorMessage(e: ApolloException) = when (e) {
        is ApolloNetworkException -> "Network not available."
        is ApolloWebSocketClosedException -> "Request timed out. Try again."
        else -> genericNetworkError
    }

    fun getErrorMessage(httpCode: Int) = when (httpCode) {
        // User unauthorised error
        401 -> "You have been unauthorized."
        // Time out error
        408 -> "Request timed out. Try again."
        // Internal server error
        500 -> "A server error occurred."
        // Any other error executing the API
        else -> genericNetworkError
    }
}