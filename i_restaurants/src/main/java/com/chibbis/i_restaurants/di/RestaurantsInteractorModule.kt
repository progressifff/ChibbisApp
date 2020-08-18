package com.chibbis.i_restaurants.di

import com.chibbis.i_restaurants.RestaurantsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RestaurantsInteractorModule {
    @Provides
    @Singleton
    internal fun providesRestaurantsApi(retrofit: Retrofit): RestaurantsApi {
        return retrofit.create(RestaurantsApi::class.java)
    }
}