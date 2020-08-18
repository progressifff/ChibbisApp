package com.chibbis.i_reviews.di

import com.chibbis.i_reviews.ReviewsApiTest
import com.chibbis.test_utils.di.PerTest
import com.chibbis.test_utils.di.TestNetworkAppComponent
import dagger.Component

@PerTest
@Component(
    dependencies = [TestNetworkAppComponent::class],
    modules = [TestReviewsModule::class]
)
interface TestReviewsComponent {
    fun inject(test: ReviewsApiTest)
}