package com.chibbis.i_reviews.di

import com.chibbis.i_reviews.ReviewsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ReviewsInteractorModule {

    @Provides
    @Singleton
    internal fun providesReviewsApi(retrofit: Retrofit): ReviewsApi {
        return retrofit.create(ReviewsApi::class.java)
    }
}