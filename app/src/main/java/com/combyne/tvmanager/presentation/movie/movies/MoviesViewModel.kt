package com.combyne.tvmanager.presentation.movie.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private var _movies = MutableLiveData<Result<List<Movie>>>()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            getMoviesUseCase.invoke(
                GetMoviesParams(
                    1
                )
            ).collect {
                _movies.postValue(it)
            }
        }
    }

    val movieList: LiveData<Result<List<Movie>>>
        get() = _movies

}