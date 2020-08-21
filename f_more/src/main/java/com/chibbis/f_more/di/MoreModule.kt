package com.chibbis.f_more.di

import androidx.lifecycle.ViewModel
import com.chibbis.base.scope.FragmentScope
import com.chibbis.base_feature.di.ViewModelKey
import com.chibbis.f_more.MoreFragmentView
import com.chibbis.f_more.MoreViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MoreModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun contributeMoreFragmentInjector(): MoreFragmentView

    @Binds
    @IntoMap
    @ViewModelKey(MoreViewModel::class)
    internal abstract fun moreViewModel(MoreViewModel: MoreViewModel): ViewModel
}