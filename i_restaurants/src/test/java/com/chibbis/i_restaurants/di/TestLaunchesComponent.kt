package com.chibbis.i_restaurants.di

import com.chibbis.i_restaurants.RestaurantsApiTest
import com.chibbis.test_utils.di.PerTest
import com.chibbis.test_utils.di.TestNetworkAppComponent
import dagger.Component

@PerTest
@Component(
    dependencies = [TestNetworkAppComponent::class],
    modules = [TestRestaurantsModule::class]
)
interface TestRestaurantsComponent {
    fun inject(test: RestaurantsApiTest)
}