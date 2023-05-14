package com.techk.pixar.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

sealed class Resource<T>(val data: T? = null, val exception: ErrorType? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(exception: ErrorType) : Resource<T>(exception = exception)
    class Loading<T> : Resource<T>()
}

enum class ErrorType {
    CONNECTION, TIMEOUT, UNKNOWN
}

class NetworkException : IOException() {
    override fun getLocalizedMessage(): String {
        return Constants.CONNECTION_ERROR_MESSAGE
    }
}

class TimeOutException : SocketTimeoutException() {
    override fun getLocalizedMessage(): String {
        return Constants.CONNECTION_ERROR_MESSAGE
    }
}

suspend fun <T : Any> safeNetworkCall(
    call: suspend () -> Response<T>
): Flow<Resource<T>> = flow {

    emit(Resource.Loading())

    runCatching {
        val response = call.invoke()
        when (response.isSuccessful && response.body() != null) {
            true -> response.body()?.let { emit(Resource.Success(it)) } ?: emit(Resource.Error(ErrorType.UNKNOWN))
            false -> Resource.Error<T>(ErrorType.UNKNOWN)
        }
    }.onFailure { exception ->
        when (exception) {
            is NetworkException -> emit(Resource.Error(ErrorType.CONNECTION))
            is TimeOutException -> emit(Resource.Error(ErrorType.TIMEOUT))
            else -> emit(Resource.Error(ErrorType.UNKNOWN))
        }
    }

}