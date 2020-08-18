package com.chibbis.f_restaurants.di

import androidx.lifecycle.ViewModel
import com.chibbis.base.scope.FragmentScope
import com.chibbis.base_feature.di.ViewModelKey
import com.chibbis.f_restaurants.RestaurantsFragmentView
import com.chibbis.f_restaurants.RestaurantsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class RestaurantsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun contributeRestaurantsFragmentInjector(): RestaurantsFragmentView

    @Binds
    @IntoMap
    @ViewModelKey(RestaurantsViewModel::class)
    internal abstract fun restaurantsViewModel(restaurantsViewModel: RestaurantsViewModel): ViewModel
}