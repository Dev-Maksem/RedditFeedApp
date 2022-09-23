package ua.devmaksem.network.data

import com.google.gson.Gson
import java.io.Reader

object ErrorUtil {

    fun parseError(charStream: Reader?): ApiError {
        charStream?.let {
            return Gson().fromJson(it, ApiError::class.java)
        }
        return ApiError(0, "Generic error", "Generic error")
    }
}