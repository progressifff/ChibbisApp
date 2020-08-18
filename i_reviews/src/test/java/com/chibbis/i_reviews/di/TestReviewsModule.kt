package com.chibbis.i_reviews.di

import com.chibbis.i_reviews.ReviewsApi
import com.chibbis.i_reviews.ReviewsRepository
import com.chibbis.test_utils.di.PerTest
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TestReviewsModule {
    @Provides
    @PerTest
    fun provideReviewsApi(retrofit: Retrofit): ReviewsApi {
        return retrofit.create(ReviewsApi::class.java)
    }

    @Provides
    @PerTest
    fun provideReviewsRepository(reviewsApi: ReviewsApi): ReviewsRepository {
        return ReviewsRepository(reviewsApi)
    }
}