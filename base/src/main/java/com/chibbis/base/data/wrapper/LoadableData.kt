package com.chibbis.base.data.wrapper

data class LoadableData<T>(
    var data: T?,
    var loadStatus: LoadStatus = LoadStatus.NORMAL
) {
    val isNormal get() = loadStatus == LoadStatus.NORMAL
    val isLoading get() = loadStatus == LoadStatus.LOADING
    val isError get() = loadStatus == LoadStatus.ERROR

    fun setNormal() { loadStatus = LoadStatus.NORMAL }
    fun setLoading() { loadStatus = LoadStatus.LOADING }
    fun setError() { loadStatus = LoadStatus.ERROR }
}