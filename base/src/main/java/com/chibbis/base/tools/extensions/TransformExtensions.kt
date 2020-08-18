package com.chibbis.base.tools.extensions

import com.chibbis.base.transform.Transformable

/**
 * Функция расширение для трансформации списка [Transformable]
 */
fun <T : Transformable<R>, R> List<T>.transformCollection(): List<R> = map { it.transform() }