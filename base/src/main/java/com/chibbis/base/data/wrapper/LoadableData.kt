package com.chibbis.base.data.wrapper

class LoadableData<T>(
    private var data: T? = null,
    private var loadStatus: LoadStatus = LoadStatus.NORMAL,
    private var isSwr: Boolean = false,
    var onMainLoading: (Boolean) -> Unit = {},
    var onSwrLoading: (Boolean) -> Unit = {},
    var onDataReady: (data: T) -> Unit = {}
) {

    fun update(
        data: T? = null,
        loadStatus: LoadStatus? = null,
        isSwr: Boolean? = null
    ) {
        data?.let { this.data = it }
        loadStatus?.let { this.loadStatus = it }
        isSwr?.let { this.isSwr = it }

        verifyMainLoading()
        verifySwrLoading()
        verifyDataReadyState()
    }

    private fun verifyMainLoading() {
        if (data == null && !loadStatus.isNormal) {
            onMainLoading(loadStatus.isLoading)
        }
    }

    private fun verifySwrLoading() {
        if (isSwr) {
            onSwrLoading(loadStatus.isLoading)
        }
    }

    private fun verifyDataReadyState() {
        val data = data
        if (data != null && !loadStatus.isLoading) {
            onDataReady(data)
        }
    }
}