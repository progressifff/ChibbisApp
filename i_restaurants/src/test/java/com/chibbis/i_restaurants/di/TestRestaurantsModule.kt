package com.chibbis.i_restaurants.di

import com.chibbis.i_restaurants.RestaurantsApi
import com.chibbis.i_restaurants.RestaurantsRepository
import com.chibbis.test_utils.di.PerTest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TestRestaurantsModule {
    @Provides
    @PerTest
    fun provideRestaurantsApi(retrofit: Retrofit): RestaurantsApi {
        return retrofit.create(RestaurantsApi::class.java)
    }

    @Provides
    @PerTest
    fun provideRestaurantsRepository(restaurantsApi: RestaurantsApi): RestaurantsRepository {
        return RestaurantsRepository(restaurantsApi)
    }
}