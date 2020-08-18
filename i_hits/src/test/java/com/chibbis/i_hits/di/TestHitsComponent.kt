package com.chibbis.i_hits.di

import com.chibbis.i_hits.HitsApiTest
import com.chibbis.test_utils.di.PerTest
import com.chibbis.test_utils.di.TestNetworkAppComponent
import dagger.Component

@PerTest
@Component(
    dependencies = [TestNetworkAppComponent::class],
    modules = [TestHitsModule::class]
)
interface TestHitsComponent {
    fun inject(test: HitsApiTest)
}