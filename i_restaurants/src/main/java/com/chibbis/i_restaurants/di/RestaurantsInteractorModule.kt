package com.chibbis.i_restaurants.di

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.i_restaurants.RestaurantsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RestaurantsInteractorModule {
    @Provides
    @ApplicationScope
    internal fun providesRestaurantsApi(retrofit: Retrofit): RestaurantsApi {
        return retrofit.create(RestaurantsApi::class.java)
    }
}