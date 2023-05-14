package com.techk.pixar.utils

sealed class Resource<T>(val data: T? = null, val exception: ErrorType? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(exception: ErrorType) : Resource<T>(exception = exception)
    class Loading<T> : Resource<T>()
}

enum class ErrorType {
    CONNECTION, TIMEOUT, UNKNOWN
}