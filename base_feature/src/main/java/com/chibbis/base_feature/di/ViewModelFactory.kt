package com.chibbis.base_feature.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chibbis.base.scope.ApplicationScope
import javax.inject.Inject
import javax.inject.Provider

@ApplicationScope
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>,
            Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider = viewModels[modelClass]
            ?: throw IllegalArgumentException("view model class $modelClass not found")
        return viewModelProvider.get() as T
    }
}