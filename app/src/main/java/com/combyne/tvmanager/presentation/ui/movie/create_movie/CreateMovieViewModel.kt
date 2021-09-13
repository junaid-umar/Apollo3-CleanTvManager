package com.combyne.tvmanager.presentation.ui.movie.create_movie

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.combyne.domain.usecase.SaveMovieParams
import com.combyne.domain.usecase.SaveMovieUseCase
import com.combyne.domain.util.Result
import com.combyne.domain.util.TimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CreateMovieViewModel
@Inject
constructor(
    private val createMovieUseCase: SaveMovieUseCase,
) : ViewModel() {


    val movie: MutableState<Result<Unit>?> = mutableStateOf(null)
    val title = mutableStateOf("")
    val releaseDate: MutableState<String?> = mutableStateOf("")
    val season: MutableState<Int?> = mutableStateOf(null)


    fun saveMovie() {
        val movieParams = SaveMovieParams(
            title.value,
            releaseDate.value?.let { if (it.isNotEmpty()) TimeUtils.stringToDate(it) else null },
            season.value
        )
        if (movieParams.isMovieValid()) {

            viewModelScope.launch {
                createMovieUseCase.invoke(
                    movieParams
                ).collect {
                    movie.value = it
                }
            }
        } else {
            movie.value = Result.Error("Title can't be empty")
        }
    }

    fun setTitle(title: String) {
        this.title.value = title
    }

    fun setReleaseDate(releaseDate: String) {
        this.releaseDate.value = releaseDate
    }

    fun setSeason(season: Int) {
        this.season.value = season
    }
}