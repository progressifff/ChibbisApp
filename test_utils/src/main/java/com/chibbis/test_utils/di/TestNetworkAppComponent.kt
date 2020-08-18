package com.chibbis.test_utils.di

import com.chibbis.i_network.di.NetworkModule
import com.chibbis.test_utils.BaseNetworkDaggerTest
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class]
)
interface TestNetworkAppComponent {
    fun inject(test: BaseNetworkDaggerTest<TestNetworkAppComponent>)
    fun provideRetrofit(): Retrofit
}