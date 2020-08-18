package com.chibbis.i_restaurants

import com.chibbis.i_restaurants.di.DaggerTestRestaurantsComponent
import com.chibbis.i_restaurants.di.TestRestaurantsComponent
import com.chibbis.test_utils.BaseNetworkDaggerTest
import junit.framework.Assert
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import javax.inject.Inject

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
        runBlocking {
            val restaurants = restaurantsRepository.getRestaurants()
            assertTrue(restaurants.isNotEmpty())
        }
    }
}