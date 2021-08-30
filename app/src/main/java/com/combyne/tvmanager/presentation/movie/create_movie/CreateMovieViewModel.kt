package com.combyne.tvmanager.presentation.movie.create_movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.combyne.domain.usecase.SaveMovieParams
import com.combyne.domain.usecase.SaveMovieUseCase
import com.combyne.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import javax.inject.Inject


@HiltViewModel
class CreateMovieViewModel
@Inject
constructor(
    private val createMovieUseCase: SaveMovieUseCase,
) : ViewModel() {


    private var _movie = MutableLiveData<Result<Unit>>()

    init {
        saveMovie("Test Movie", null, 12)
    }

    fun saveMovie(title: String, releaseDate: ZonedDateTime?, season: Int?) {

        if (title.isBlank()) {
            _movie.postValue(Result.Error("title can't be empty"))
        } else {
            viewModelScope.launch {
                createMovieUseCase.invoke(
                    SaveMovieParams(
                        title,
                        releaseDate,
                        season
                    )
                ).collect {
                    _movie.postValue(it)
                }
            }
        }


    }

    val movie: LiveData<Result<Unit>>
        get() = _movie

}