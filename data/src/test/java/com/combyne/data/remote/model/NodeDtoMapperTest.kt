package com.combyne.data.remote.model

import com.combyne.data.FakeDataUtil
import com.combyne.domain.model.Movie
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class NodeDtoMapperTest {

    private lateinit var nodeDtoMapper: NodeDtoMapper

    @Before
    fun setUp() {
        nodeDtoMapper = NodeDtoMapper()
    }

    @Test
    fun toDomainModel() {
        val output = nodeDtoMapper.toDomainModel(
            FakeDataUtil.Data.node1
        )
        assertThat(output).isEqualTo(FakeDataUtil.Domain.movie1)
    }

    @Test
    fun givenData_returnMovies() {
        val output = FakeDataUtil.Data.GetMoviesQueryData.getDataOrNull()

        assertThat(output).isEqualTo(FakeDataUtil.Domain.movies)
    }

    @Test
    fun givenEmptyData_returnEmptyList() {
        val output = FakeDataUtil.Data.GetMoviesQueryDataEmpty.getDataOrNull()

        assertThat(output).isEqualTo(emptyList<List<Movie>>())
    }
}
