package com.chibbis.test_utils.di

import com.chibbis.base.scope.ApplicationScope
import com.chibbis.i_network.di.NetworkModule
import com.chibbis.test_utils.BaseNetworkDaggerTest
import dagger.Component
import retrofit2.Retrofit

@ApplicationScope
@Component(
    modules = [NetworkModule::class]
)
interface TestNetworkAppComponent {
    fun inject(test: BaseNetworkDaggerTest<TestNetworkAppComponent>)
    fun provideRetrofit(): Retrofit
}