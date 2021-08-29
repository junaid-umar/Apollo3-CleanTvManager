package com.combyne.data.remote.util

import com.apollographql.apollo3.exception.ApolloNetworkException
import com.apollographql.apollo3.exception.JsonEncodingException
import com.google.common.truth.Truth
import org.junit.Test

class NetworkUtilsTest {

    @Test
    fun whenApolloNetworkException_thenReturnMessage() {

        val output = NetworkUtils.getNetworkErrorMessage(ApolloNetworkException())

        Truth.assertThat(output).isEqualTo("Network not available.")
    }

    @Test
    fun whenRandomException_thenReturnGenericMessage() {

        val output = NetworkUtils.getNetworkErrorMessage(JsonEncodingException("test exception"))

        Truth.assertThat(output).isEqualTo("An error occurred getting data from server.")
    }

    @Test
    fun whenHttpCode_thenReturnMessage() {

        val output = NetworkUtils.getErrorMessage(401)

        Truth.assertThat(output).isEqualTo("You have been unauthorized.")
    }

    @Test
    fun whenRandomHttpCode_thenReturnGenericMessage() {

        val output = NetworkUtils.getErrorMessage(801)

        Truth.assertThat(output).isEqualTo("An error occurred getting data from server.")
    }
}