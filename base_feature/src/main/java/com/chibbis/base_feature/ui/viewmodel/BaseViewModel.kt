package com.chibbis.base_feature.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chibbis.base_feature.ui.error.ErrorHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

open class BaseViewModel : ViewModel() {

    @Inject
    lateinit var errorHandler: ErrorHandler

    protected fun <T> doWork(
        todoBlock: suspend CoroutineScope.() -> T,
        onError: (t: Throwable) -> Unit
    ): Job = viewModelScope.launch {
            try {
                todoBlock.invoke(this)
            } catch (t: Throwable) {
                handleError(t)
                onError(t)
            }
        }

    protected fun <T> doWork(todoBlock: suspend CoroutineScope.() -> T): Job = doWork(todoBlock, {})

    protected fun handleError(t: Throwable) {
        errorHandler.handleError(t)
    }
}