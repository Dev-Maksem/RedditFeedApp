package ua.devmaksem.network.http_builder

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import ua.devmaksem.network.factory.ServiceProperties.Companion.TIMEOUT
import java.util.concurrent.TimeUnit

internal class DefaultOKHttpClientBuilder : OKHttpClientBuilderFactory {

    companion object {
        private const val KEY_AUTHORIZATION = "Authorization"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
    }

    override fun addNetworkInterceptor(interceptor: Interceptor) = Unit

    override fun addApplicationInterceptor(interceptor: Interceptor) = Unit

    override fun createBuilder(): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder().also {
            it.followRedirects(true)
            it.followSslRedirects(true)
            it.connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            it.readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            it.writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            it.addInterceptor { chain ->
                val original = chain.request()
                val requestBuild = original.newBuilder()
                //requestBuild.addHeader(KEY_AUTHORIZATION, "Bearer ${AuthSettings.accessToken}")
                val request = requestBuild.build()
                return@addInterceptor chain.proceed(request)
            }
        }
        return builder
    }

    override fun createAuthBuilder(): OkHttpClient.Builder {
//        val credentials = "some_username:some_password"
//        val basic = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
//            "Basic " + Base64.encodeToString(credentials.encodeToByteArray(), Base64.NO_WRAP)
//        } else {
//            ""
//        }

        val builder = OkHttpClient.Builder().also {
            it.followRedirects(true)
            it.followSslRedirects(true)
            it.addInterceptor { chain ->
                val original = chain.request()
                val requestBuild = original.newBuilder()//.also {
//                    it.addHeader(KEY_AUTHORIZATION, basic)
//                    it.addHeader(KEY_USERNAME, "some_username")
//                    it.addHeader(KEY_PASSWORD, "some_password")
//                }
                val request = requestBuild.build()
                return@addInterceptor chain.proceed(request)
            }
        }
        return builder
    }
}
