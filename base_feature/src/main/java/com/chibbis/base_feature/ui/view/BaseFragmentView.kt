package com.chibbis.base_feature.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Dagger fragment with ViewModel provider.
 */
abstract class BaseFragmentView<T : ViewModel> : ThinFragmentView() {

    protected abstract val viewModelClass: Class<T>

    private var rootView: View? = null
    private var hasInitializedRootView = false
    private val viewModelsProvider: ViewModelProvider by lazy {
        ViewModelProvider(this, viewModelFactory)
    }

    protected open val viewModel: T by lazy { viewModelsProvider[viewModelClass] }

    protected fun <S : ViewModel> getViewModel(viewModelClass: Class<S>) =
        viewModelsProvider[viewModelClass]

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = rootView
        return if (view == null) {
            createRootView(
                inflater,
                container,
                savedInstanceState
            ).also { rootView = it }
        } else {
            (view.parent as? ViewGroup)?.removeView(view)
            view
        }
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasInitializedRootView) {
            onRootViewCreated()
            hasInitializedRootView = true
        }

    }

    abstract fun createRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    abstract fun onRootViewCreated()
}