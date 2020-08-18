package com.chibbis.test_utils

import com.chibbis.i_network.di.NetworkModule
import com.chibbis.test_utils.di.DaggerTestNetworkAppComponent
import com.chibbis.test_utils.di.TestNetworkAppComponent
import org.junit.Before

abstract class BaseNetworkDaggerTest<T> {
    protected val networkComponent: TestNetworkAppComponent =
        DaggerTestNetworkAppComponent.builder()
            .networkModule(NetworkModule())
            .build()

    abstract val component: T

    abstract fun inject()

    @Before
    open fun setUp() {
        inject()
    }
}