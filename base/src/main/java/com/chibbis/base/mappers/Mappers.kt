package com.chibbis.base.mappers

/**
 * Возвращает дефолтное значение [String] если это null
 */
val String?.nonNull: String get() = this ?: ""

/**
 * Возвращает дефолтное значение [Int] если это null
 */
val Int?.nonNull: Int get() = this ?: 0

/**
 * Возвращает дефолтное значение [Float] если это null
 */
val Float?.nonNull: Float get() = this ?: 0f

/**
 * Возвращает дефолтное значение [Double] если это null
 */
val Double?.nonNull: Double get() = this ?: .0

/**
 * Возвращает дефолтное значение [Boolean] если это null
 */
val Boolean?.nonNull: Boolean get() = this ?: false

/**
 * Возвращает дефолтное значение [List] если это null
 */
val <T : Any> List<T?>?.nonNull: List<T> get() = this?.filterNotNull() ?: emptyList()