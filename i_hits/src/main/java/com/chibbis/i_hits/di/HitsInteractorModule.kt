package com.chibbis.i_hits.di

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.i_hits.HitsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HitsInteractorModule {

    @Provides
    @ApplicationScope
    internal fun providesHitsApi(retrofit: Retrofit): HitsApi {
        return retrofit.create(HitsApi::class.java)
    }
}