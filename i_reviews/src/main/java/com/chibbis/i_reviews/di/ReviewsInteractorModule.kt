package com.chibbis.i_reviews.di

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.i_reviews.ReviewsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ReviewsInteractorModule {

    @Provides
    @ApplicationScope
    internal fun providesReviewsApi(retrofit: Retrofit): ReviewsApi {
        return retrofit.create(ReviewsApi::class.java)
    }
}