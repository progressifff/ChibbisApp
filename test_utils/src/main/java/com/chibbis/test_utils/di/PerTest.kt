package com.chibbis.test_utils.di

import javax.inject.Scope

/**
 * Dagger scope для тестов
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerTest