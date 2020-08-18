package com.chibbis.chibbisapp.di

import android.app.Application
import android.content.Context
import com.chibbis.base.other.ActiveActivityHolder
import com.chibbis.base.scope.ApplicationScope
import com.chibbis.base_feature.di.ViewModelModule
import com.chibbis.base_feature.ui.message.MessageController
import com.chibbis.base_feature.ui.message.StandardMessageController
import com.chibbis.chibbisapp.App
import dagger.Module
import dagger.Provides

@Module(includes = [ViewModelModule::class])
class AppModule(private val app: App) {

    @Provides
    @ApplicationScope
    fun provideContext(): Context = app

    @Provides
    @ApplicationScope
    fun provideApp(): Application = app

    @Provides
    @ApplicationScope
    internal fun provideMessageController(): MessageController {
        return StandardMessageController(
            app.activeActivityHolder,
            app
        )
    }

    @Provides
    @ApplicationScope
    internal fun provideActiveActivityHolder(): ActiveActivityHolder = app.activeActivityHolder
}