package com.chibbis.base_feature.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Basic fragment view with view model factory
 */
abstract class ThinFragmentView : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val navigationController: NavController by lazy { findNavController() }

    private val activityViewModelsProvider: ViewModelProvider by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(getContentView(), container, false)

    @LayoutRes
    protected abstract fun getContentView(): Int

    protected fun <S : ViewModel> getActivityViewModel(viewModelClass: Class<S>) =
        activityViewModelsProvider[viewModelClass]

    protected fun <T> LiveData<out T>.observe(observer: (T) -> Unit) {
        observe(this@ThinFragmentView, Observer { observer(it) })
    }
}