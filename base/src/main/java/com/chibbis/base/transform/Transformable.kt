package com.chibbis.base.transform

/**
 * Интерфейс объекта для трансформации в доменную модель
 */
interface Transformable<T> {
    fun transform(): T
}