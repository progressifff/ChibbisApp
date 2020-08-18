package com.chibbis.f_splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private const val MAIN_ACTIVITY_CLASS_PATH = "com.chibbis.f_main.MainActivityView"

/**
 * Вью splash
 */
class SplashActivityView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Intent().setClassName(this@SplashActivityView, MAIN_ACTIVITY_CLASS_PATH).run {
            startActivity(this)
            finish()
        }
    }
}