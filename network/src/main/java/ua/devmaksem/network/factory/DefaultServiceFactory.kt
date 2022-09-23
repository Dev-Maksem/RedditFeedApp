package ua.devmaksem.network.factory

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ua.devmaksem.network.adapters.DateTypeAdapter
import ua.devmaksem.network.factory.ServiceProperties.Companion.BASE_URL
import ua.devmaksem.network.factory.ServiceProperties.Companion.DATE_FORMAT
import ua.devmaksem.network.http_builder.OKHttpClientBuilderFactory
import java.util.Date

internal open class DefaultServiceFactory<T>(
    private val clientBuilderFactory: OKHttpClientBuilderFactory,
    private val serviceClass: Class<T>,
    private val serverUrl: String? = null
) : ServiceFactory<T> {

    override fun createService(jsonAdapters: List<Any>): T {
        val okHttpClient = createOKHttpClient()
        val retrofit = createRetrofit(okHttpClient)
        return retrofit.create(serviceClass)
    }

    override fun createAuthService(): T {
        val okHttpClient = createAuthHttpClient()
        val retrofit = createRetrofit(okHttpClient)
        return retrofit.create(serviceClass)
    }

    private fun createOKHttpClient(): OkHttpClient {
        return clientBuilderFactory.createBuilder().build()
    }

    private fun createAuthHttpClient(): OkHttpClient {
        return clientBuilderFactory.createAuthBuilder().build()
    }

    private fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(provideServerUrl())
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(buildJsonConverter()))
            .build()
    }

    private fun provideServerUrl() = serverUrl ?: BASE_URL

    open fun buildJsonConverter(): Gson {
        return GsonBuilder()
            .setDateFormat(DATE_FORMAT)
            .registerTypeAdapter(Date::class.java, DateTypeAdapter())
            .setLenient()
            .create()
    }
}