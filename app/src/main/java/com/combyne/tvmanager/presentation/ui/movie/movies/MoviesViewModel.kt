package com.combyne.tvmanager.presentation.ui.movie.movies

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.combyne.domain.model.Movie
import com.combyne.domain.usecase.GetMoviesParams
import com.combyne.domain.usecase.GetMoviesUseCase
import com.combyne.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel
@Inject
constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {
    val movies: MutableState<Map<Char, List<Movie>>> = mutableStateOf(mapOf())
    val loading = mutableStateOf(false)
    val error = mutableStateOf("")
    val query = mutableStateOf("")

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            getMoviesUseCase.invoke(
                GetMoviesParams(
                    1
                )
            ).collect {
                if (it is Result.Success) {
                    movies.value = it.data.sortedBy { it.title }.groupBy { it.title[0] }
                    loading.value = false
                } else if (it is Result.Loading) {
                    loading.value = true
                } else if (it is Result.Error) {
                    error.value = it.error
                    loading.value = false
                }
            }
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }
}