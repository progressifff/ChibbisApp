package com.chibbis.base_feature.ui.view

import android.graphics.Color
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.chibbis.base_feature.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Dagger activity with ViewModel provider.
 */
abstract class BaseActivityView<T : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModelClass: Class<T>

    private val viewModelsProvider: ViewModelProvider by lazy {
        ViewModelProviders.of(this, viewModelFactory)
    }

    protected open val viewModel: T by lazy { getViewModel(viewModelClass) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setTheme()
        window.navigationBarColor = Color.BLACK
        setContentView(getContentView())
    }

    @LayoutRes
    protected abstract fun getContentView(): Int

    protected fun <S : ViewModel> getViewModel(viewModelClass: Class<S>) =
        viewModelsProvider[viewModelClass]

    protected fun <T> LiveData<out T>.observe(observer: (T) -> Unit) {
        observe(this@BaseActivityView, Observer { observer(it) })
    }

    private fun setTheme() {
        setTheme(R.style.AppThemeLight)
    }
}