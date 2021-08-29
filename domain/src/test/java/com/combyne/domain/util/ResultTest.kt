package com.combyne.domain.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ResourceTest {

    @Test
    fun givenResultSuccess_returnsTransformedSuccess() {
        val input = Result.Success("data")
        val output = input.transform { "data" + "data" }
        assertThat((output as Result.Success).data).isEqualTo("datadata")
    }

    @Test
    fun givenResultError_returnsTransformedError() {
        val input = Result.Error("error")
        val output = input.transform { "error" }
        assertThat((output as Result.Error).error).isEqualTo("error")
    }

    @Test
    fun givenResultLoading_returnsTransformedLoading() {
        val input = Result.Loading("data")
        val output = input.transform { "data" + "data" }
        assertThat((output as Result.Loading).data).isEqualTo("datadata")
    }

    @Test
    fun givenResultSuccess_returnsData() {
        val input = Result.Success("test")
        assertThat(input.getDataOrNull()).isEqualTo("test")
    }

    @Test
    fun givenResultError_returnsDataNull() {
        val input = Result.Error("error")
        assertThat(input.getDataOrNull<String>()).isEqualTo(null)
    }

    @Test
    fun givenResourceLoading_returnsData() {
        val input = Result.Loading("loading")
        assertThat(input.getDataOrNull()).isEqualTo("loading")
    }
}