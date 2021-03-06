package com.chibbis.base_feature.ui.error

import android.text.TextUtils
import android.util.Log
import com.chibbis.base_feature.R
import com.chibbis.base_feature.ui.message.MessageController
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class StandardErrorHandler @Inject constructor(private val messageController: MessageController) :
    ErrorHandler {
    override fun handleError(t: Throwable) {
        when (t) {
            is HttpException -> handleHttpException(t)
            is IOException -> handleNoInternetException()
        }
    }

    private fun handleHttpException(e: HttpException) {
        if (e.code() >= CODE_500) {
            messageController.showSnack(R.string.server_error_message)
        } else if (e.code() == CODE_403) {
            messageController.showSnack(R.string.forbidden_error_error_message)
        } else if (!TextUtils.isEmpty(e.message())) {
            Log.e("StandardErrorHandler", e.message())
        } else if (e.code() == CODE_404) {
            messageController.showSnack(R.string.server_error_not_found)
        } else {
            messageController.showSnack(R.string.default_http_error_message)
        }
    }

    private fun handleNoInternetException() {
        messageController.showSnack(R.string.no_internet_connection_error_message)
    }

    private companion object {
        val CODE_403 = 403
        val CODE_404 = 404
        val CODE_500 = 500
    }
}