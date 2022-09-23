package ua.devmaksem.network.http_builder

import okhttp3.Interceptor
import okhttp3.OkHttpClient

internal interface OKHttpClientBuilderFactory {
    fun addNetworkInterceptor(interceptor: Interceptor)
    fun addApplicationInterceptor(interceptor: Interceptor)
    fun createBuilder(): OkHttpClient.Builder
    fun createAuthBuilder(): OkHttpClient.Builder
}