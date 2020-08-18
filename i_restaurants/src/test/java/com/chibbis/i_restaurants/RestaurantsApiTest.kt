package com.chibbis.i_restaurants

import android.os.Build
import com.chibbis.i_restaurants.di.TestRestaurantsComponent
import com.chibbis.test_utils.BaseNetworkDaggerTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class RestaurantsApiTest : BaseNetworkDaggerTest<TestRestaurantsComponent>() {

    override val component: TestRestaurantsComponent = DaggerTestRestaurantsComponent.builder()
        .testNetworkAppComponent(networkComponent)
        .build()

    override fun inject() {
        component.inject(this)
    }

    @Inject
    lateinit var restaurantsRepository: RestaurantsRepository

    @Test
    fun testSuccessLoadRestaurants() {

    }
}