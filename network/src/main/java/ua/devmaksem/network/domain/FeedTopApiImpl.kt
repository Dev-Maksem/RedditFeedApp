package ua.devmaksem.network.domain

import ua.devmaksem.network.data.ApiResult
import ua.devmaksem.network.data.top.FeedDto
import ua.devmaksem.network.factory.ServiceFactory
import ua.devmaksem.network.safeApiCall
import ua.devmaksem.network.services.FeedTopService

internal class FeedTopApiImpl(
    private val factory: ServiceFactory<FeedTopService>
) : FeedTopApi {

    private val service: FeedTopService by lazy { factory.createService() }

    override suspend fun getFeed(): ApiResult<FeedDto> {
        return safeApiCall(errorMsg = "Failed to fetch getFeed()") {
            service.getFeed()
        }
    }
}