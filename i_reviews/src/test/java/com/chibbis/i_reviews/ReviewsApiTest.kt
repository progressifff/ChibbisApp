package com.chibbis.i_reviews

import android.os.Build
import com.chibbis.i_reviews.di.TestReviewsComponent
import com.chibbis.test_utils.BaseNetworkDaggerTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
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

    }
}