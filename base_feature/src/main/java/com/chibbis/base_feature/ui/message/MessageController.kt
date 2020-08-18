package com.chibbis.base_feature.ui.message

import android.view.Gravity
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

interface MessageController {

    fun showToast(@StringRes stringId: Int,
                  gravity: Int = DEFAULT_TOAST_GRAVITY,
                  duration: Int = DEFAULT_TOAST_DURATION
    )

    fun showToast(message: String,
                  gravity: Int = DEFAULT_TOAST_GRAVITY,
                  duration: Int = Toast.LENGTH_LONG)

    fun showSnack(@StringRes stringId: Int,
                  duration: Int = DEFAULT_SNACK_DURATION
    )

    fun showSnack(message: String,
                  duration: Int = DEFAULT_SNACK_DURATION
    )

    companion object {
        private const val DEFAULT_TOAST_GRAVITY = Gravity.BOTTOM
        private const val DEFAULT_TOAST_DURATION = Toast.LENGTH_LONG
        private const val DEFAULT_SNACK_DURATION = Snackbar.LENGTH_LONG
        private const val DEFAULT_TAG = "TAG"
    }
}