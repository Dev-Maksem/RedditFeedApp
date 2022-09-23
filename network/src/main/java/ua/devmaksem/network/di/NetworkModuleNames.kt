package ua.devmaksem.network.di

import org.koin.core.qualifier.named

object NetworkModuleNames {
    val OK_BUILDER = named("OkBuilder")
    val FEED_TOP_SERVICE = named("FeedTopService")
}