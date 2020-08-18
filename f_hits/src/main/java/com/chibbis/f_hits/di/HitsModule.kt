package com.chibbis.f_hits.di

import androidx.lifecycle.ViewModel
import com.chibbis.base.scope.FragmentScope
import com.chibbis.base_feature.di.ViewModelKey
import com.chibbis.f_hits.HitsFragmentView
import com.chibbis.f_hits.HitsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HitsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun contributeHitsFragmentInjector(): HitsFragmentView

    @Binds
    @IntoMap
    @ViewModelKey(HitsViewModel::class)
    internal abstract fun hitsViewModel(hitsViewModel: HitsViewModel): ViewModel
}