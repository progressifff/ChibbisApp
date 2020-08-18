package com.chibbis.base_feature.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * Dagger fragment with ViewModel provider.
 */
abstract class BaseFragmentView<T : ViewModel> : ThinFragmentView() {

    protected abstract val viewModelClass: Class<T>

    private val viewModelsProvider: ViewModelProvider by lazy {
        ViewModelProviders.of(this, viewModelFactory)
    }

    protected open val viewModel: T by lazy { viewModelsProvider[viewModelClass] }

    protected fun <S : ViewModel> getViewModel(viewModelClass: Class<S>) =
        viewModelsProvider[viewModelClass]
}