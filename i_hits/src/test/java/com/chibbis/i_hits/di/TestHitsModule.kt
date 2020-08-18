package com.chibbis.i_hits.di

import com.chibbis.i_hits.HitsApi
import com.chibbis.i_hits.HitsRepository
import com.chibbis.test_utils.di.PerTest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TestHitsModule {
    @Provides
    @PerTest
    fun provideHitsApi(retrofit: Retrofit): HitsApi {
        return retrofit.create(HitsApi::class.java)
    }

    @Provides
    @PerTest
    fun provideHitsRepository(reviewsApi: HitsApi): HitsRepository {
        return HitsRepository(reviewsApi)
    }
}