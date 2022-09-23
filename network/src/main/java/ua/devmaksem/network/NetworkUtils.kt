package ua.devmaksem.network

import retrofit2.Response
import ua.devmaksem.network.data.ApiError
import ua.devmaksem.network.data.ApiResult

internal suspend fun <T : Any> safeApiCall(
    errorMsg: String,
    call: suspend () -> Response<T>
): ApiResult<T> {
    return safeApiResult(call, errorMsg)
}

private suspend fun <T : Any> safeApiResult(
    call: suspend () -> Response<T>,
    errorMessage: String
): ApiResult<T> {
    return try {
        val response = call.invoke()
        if (response.isSuccessful) {
            ApiResult.Success(
                response.body()!!
            )
        } else {
            ApiResult.Error(response.code(), ApiError(0, errorMessage, response.message()))
        }
    } catch (throwable: Throwable) {
        ApiResult.Error(0, ApiError(0, throwable.message.toString(), throwable.message.toString()))
    }
}

internal suspend fun <T : Any> safeApiCall(
    successMsg: String,
    errorMsg: String,
    call: suspend () -> Response<T>,
): ApiResult<String> {
    return safeApiResultString(call, errorMsg, successMsg)
}

private suspend fun <T : Any> safeApiResultString(
    call: suspend () -> Response<T>,
    errorMessage: String,
    successMsg: String
): ApiResult<String> {
    return try {
        val response = call.invoke()
        if (response.isSuccessful) {
            ApiResult.Success(successMsg)
        } else {
            ApiResult.Error(response.code(), ApiError(0, errorMessage, response.message()))
        }
    } catch (throwable: Throwable) {
        ApiResult.Error(
            errorCode = 0,
            ApiError(
                0,
                throwable.message ?: errorMessage,
                throwable.message ?: errorMessage
            )
        )
    }
}