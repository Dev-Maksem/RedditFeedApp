package ua.devmaksem.network.data

sealed class ApiResult<T> {
    class Success<T>(val data: T) : ApiResult<T>()
    class Error<T>(val errorCode: Int = 0, val errorMessage: ApiError) : ApiResult<T>()

    var isSuccess: Boolean = false
}
