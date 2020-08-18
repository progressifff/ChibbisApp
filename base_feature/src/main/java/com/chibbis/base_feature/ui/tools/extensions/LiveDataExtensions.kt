package com.chibbis.base_feature.ui.tools.extensions

import androidx.lifecycle.MutableLiveData
import com.chibbis.base.data.wrapper.LoadableData

fun <T> MutableLiveData<LoadableData<T>>.setLoading() {
    value?.let {
        postValue(it.apply { setLoading() })
    }
}

fun <T> MutableLiveData<LoadableData<T>>.setNormalData(data: T) {
    value?.let {
        postValue(
            it.apply {
                this.data = data
                setNormal()
            }
        )
    }
}

fun <T> MutableLiveData<LoadableData<T>>.setError() {
    value?.let {
        postValue(it.apply { setError() })
    }
}