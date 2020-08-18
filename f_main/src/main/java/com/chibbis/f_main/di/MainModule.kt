package com.chibbis.f_main.di

import androidx.lifecycle.ViewModel
import com.chibbis.base.scope.ActivityScope
import com.chibbis.base_feature.di.ViewModelKey
import com.chibbis.f_main.MainActivityView
import com.chibbis.f_main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun contributeMainActivityInjector(): MainActivityView

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(mainViewModel: MainViewModel): ViewModel
}