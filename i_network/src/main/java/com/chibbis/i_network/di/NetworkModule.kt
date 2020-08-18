package com.chibbis.i_network.di

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.i_network.API_URL
import com.chibbis.i_network.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val NETWORK_TIMEOUT = 5L //minutes

@Module
class NetworkModule {

    @Provides
    @ApplicationScope
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .apply {
                level = when (BuildConfig.BUILD_TYPE) {
                    "debug" -> HttpLoggingInterceptor.Level.BODY
                    "release" -> HttpLoggingInterceptor.Level.NONE
                    else -> error("Unsupported BuildType ${BuildConfig.BUILD_TYPE}")
                }
            }
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(NETWORK_TIMEOUT, TimeUnit.MINUTES)
            readTimeout(NETWORK_TIMEOUT, TimeUnit.MINUTES)
            writeTimeout(NETWORK_TIMEOUT, TimeUnit.MINUTES)
            addInterceptor(httpLoggingInterceptor)
        }.build()
    }

    @Provides
    @ApplicationScope
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}