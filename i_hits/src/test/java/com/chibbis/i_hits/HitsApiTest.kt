package com.chibbis.i_hits

import com.chibbis.i_hits.di.DaggerTestHitsComponent
import com.chibbis.i_hits.di.TestHitsComponent
import com.chibbis.test_utils.BaseNetworkDaggerTest
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test
import javax.inject.Inject

class HitsApiTest : BaseNetworkDaggerTest<TestHitsComponent>() {

    override val component: TestHitsComponent = DaggerTestHitsComponent.builder()
        .testNetworkAppComponent(networkComponent)
        .build()

    override fun inject() {
        component.inject(this)
    }

    @Inject
    lateinit var hitsRepository: HitsRepository

    @Test
    fun testSuccessLoadHits() {
        runBlocking {
            val hits = hitsRepository.getHits()
            assertTrue(hits.isNotEmpty())
        }
    }
}