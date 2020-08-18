package com.chibbis.chibbisapp

import android.content.Context
import androidx.multidex.MultiDex
import com.jakewharton.threetenabp.AndroidThreeTen
import com.chibbis.base.other.ActiveActivityHolder
import com.chibbis.base.other.ActivityLifecycleListener
import com.chibbis.chibbisapp.di.AppModule
import com.chibbis.chibbisapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Класс приложения
 */
class App : DaggerApplication() {

    val activeActivityHolder = ActiveActivityHolder()

    private val applicationInjector: AndroidInjector<out DaggerApplication> by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun applicationInjector() = applicationInjector

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        initLifeCycleListeners()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun initLifeCycleListeners() {

        val activityLifecycleCallBack = ActivityLifecycleListener(
            onActivityResumed = { activity ->
                activeActivityHolder.activity = activity
            },
            onActivityPaused = {
                activeActivityHolder.clear()
            }
        )
        registerActivityLifecycleCallbacks(activityLifecycleCallBack)
    }
}