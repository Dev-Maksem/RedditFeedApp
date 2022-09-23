package ua.devmaksem.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ua.devmaksem.network.data.top.FeedDto

interface FeedTopService {
    companion object {
        const val API_PATH = "/top"
    }

    /**
     * This endpoint is a **listing**
     */
    @GET("$API_PATH.json")
    fun getFeed(
        @Query("raw_json") rawJson: Int = 1
    ): Response<FeedDto>
}