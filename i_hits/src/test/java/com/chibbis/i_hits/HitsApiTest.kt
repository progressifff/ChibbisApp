package com.chibbis.i_hits

import android.os.Build
import com.chibbis.i_hits.di.TestHitsComponent
import com.chibbis.test_utils.BaseNetworkDaggerTest
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
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

    }
}