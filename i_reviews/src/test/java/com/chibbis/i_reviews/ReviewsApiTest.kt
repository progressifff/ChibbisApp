package com.chibbis.i_reviews

import com.chibbis.i_reviews.di.DaggerTestReviewsComponent
import com.chibbis.i_reviews.di.TestReviewsComponent
import com.chibbis.test_utils.BaseNetworkDaggerTest
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import javax.inject.Inject

class ReviewsApiTest : BaseNetworkDaggerTest<TestReviewsComponent>() {

    override val component: TestReviewsComponent = DaggerTestReviewsComponent.builder()
        .testNetworkAppComponent(networkComponent)
        .build()

    override fun inject() {
        component.inject(this)
    }

    @Inject
    lateinit var reviewsRepository: ReviewsRepository

    @Test
    fun testSuccessLoadReviews() {
        runBlocking {
            val reviews = reviewsRepository.getReviews()
            assertTrue(reviews.isNotEmpty())
        }
    }
}