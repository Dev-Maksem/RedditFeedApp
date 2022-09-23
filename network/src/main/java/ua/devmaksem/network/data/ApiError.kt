package ua.devmaksem.network.data

data class ApiError(
    val statusCode: Int,
    val message: String,
    val error: String
)
