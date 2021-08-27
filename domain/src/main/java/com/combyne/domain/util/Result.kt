package com.combyne.domain.util

import com.combyne.domain.util.Result.*

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
    data class Loading<out T>(val data: T? = null) : Result<T>()

}

fun <T, R> Result<T>.transform(
    transform: ((value: T) -> R),
): Result<R> = when (this) {
    is Success -> Success(transform.invoke(data))
    is Error -> Error(error)
    is Loading -> Loading(data?.let { transform.invoke(it) })
}

fun <T> Result<T>.getDataOrNull() = when (this) {
    is Success -> data
    is Loading -> data
    is Error -> null
}