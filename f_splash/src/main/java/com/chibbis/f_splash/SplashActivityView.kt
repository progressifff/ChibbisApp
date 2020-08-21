package com.chibbis.f_splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

/**
 * Вью splash
 */
class SplashActivityView : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        activityScope.launch {
            delay(resources.getInteger(R.integer.splash_delay_millis).toLong())
            Intent().setClassName(this@SplashActivityView, MAIN_ACTIVITY_CLASS_PATH).run {
                startActivity(this)
                finish()
            }
        }
    }

    override fun onDestroy() {
        activityScope.cancel()
        super.onDestroy()
    }

    private companion object {
        const val MAIN_ACTIVITY_CLASS_PATH = "com.chibbis.f_main.MainActivityView"
    }
}