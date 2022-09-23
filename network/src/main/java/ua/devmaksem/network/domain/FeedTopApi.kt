package ua.devmaksem.network.domain

import ua.devmaksem.network.data.ApiResult
import ua.devmaksem.network.data.top.FeedDto

interface FeedTopApi {
    suspend fun getFeed(): ApiResult<FeedDto>
}