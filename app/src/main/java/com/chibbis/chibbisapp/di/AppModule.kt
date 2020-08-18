package com.chibbis.chibbisapp.di

import android.app.Application
import android.content.Context
import com.chibbis.base.other.ActiveActivityHolder
import com.chibbis.base_feature.di.ViewModelModule
import com.chibbis.base_feature.ui.message.MessageController
import com.chibbis.base_feature.ui.message.StandardMessageController
import com.chibbis.chibbisapp.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApp(): Application = app

    @Provides
    @Singleton
    internal fun provideMessageController(): MessageController {
        return StandardMessageController(
            app.activeActivityHolder,
            app
        )
    }

    @Provides
    @Singleton
    internal fun provideActiveActivityHolder(): ActiveActivityHolder = app.activeActivityHolder
}