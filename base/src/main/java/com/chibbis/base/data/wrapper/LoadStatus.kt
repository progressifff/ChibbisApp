package com.chibbis.base.data.wrapper

enum class LoadStatus {
    NORMAL,
    LOADING,
    ERROR;

    val isNormal: Boolean get() = this == NORMAL
    val isLoading: Boolean get() = this == LOADING
    val isError: Boolean get() = this == ERROR
}