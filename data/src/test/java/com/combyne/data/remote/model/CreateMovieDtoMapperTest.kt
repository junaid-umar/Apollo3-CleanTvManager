package com.combyne.data.remote.model

import com.combyne.data.FakeDataUtil
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CreateMovieDtoMapperTest {

    private lateinit var createMovieDtoMapper: CreateMovieDtoMapper

    @Before
    fun setUp() {
        createMovieDtoMapper = CreateMovieDtoMapper()
    }

    @Test
    fun toDomainModel() {
        val output = createMovieDtoMapper.toDomainModel(
            FakeDataUtil.Data.movie1
        )

        assertThat(output).isEqualTo(FakeDataUtil.Domain.movie1)
    }
}