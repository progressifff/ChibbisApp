package com.chibbis.base_feature.di

import com.chibbis.base_feature.ui.error.ErrorHandler
import com.chibbis.base_feature.ui.error.StandardErrorHandler
import dagger.Module
import dagger.Provides

@Module
class ErrorHandlerModule {
    @Provides
    fun provideNetworkErrorHandler(standardErrorHandler: StandardErrorHandler): ErrorHandler {
        return standardErrorHandler
    }
}