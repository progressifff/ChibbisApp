package com.chibbis.i_hits.di

import com.chibbis.i_hits.HitsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class HitsInteractorModule {

    @Provides
    @Singleton
    internal fun providesHitsApi(retrofit: Retrofit): HitsApi {
        return retrofit.create(HitsApi::class.java)
    }
}