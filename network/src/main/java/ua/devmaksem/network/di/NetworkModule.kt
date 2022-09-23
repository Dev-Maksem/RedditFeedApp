package ua.devmaksem.network.di

import org.koin.dsl.module
import ua.devmaksem.network.di.NetworkModuleNames.FEED_TOP_SERVICE
import ua.devmaksem.network.di.NetworkModuleNames.OK_BUILDER
import ua.devmaksem.network.domain.FeedTopApi
import ua.devmaksem.network.domain.FeedTopApiImpl
import ua.devmaksem.network.factory.DefaultServiceFactory
import ua.devmaksem.network.factory.ServiceFactory
import ua.devmaksem.network.factory.ServiceProperties.Companion.BASE_URL
import ua.devmaksem.network.http_builder.DefaultOKHttpClientBuilder
import ua.devmaksem.network.http_builder.OKHttpClientBuilderFactory
import ua.devmaksem.network.services.FeedTopService

val networkModule = module {
    single<OKHttpClientBuilderFactory>(OK_BUILDER) {
        DefaultOKHttpClientBuilder()
    }

    single<ServiceFactory<FeedTopService>>(FEED_TOP_SERVICE) {
        DefaultServiceFactory(
            clientBuilderFactory = get(OK_BUILDER),
            serviceClass = FeedTopService::class.java,
            serverUrl = BASE_URL
        )
    }

    factory<FeedTopApi> {
        FeedTopApiImpl(get(FEED_TOP_SERVICE))
    }
}