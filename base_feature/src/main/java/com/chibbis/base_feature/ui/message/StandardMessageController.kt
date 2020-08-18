package com.chibbis.base_feature.ui.message

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.chibbis.base.other.ActiveActivityHolder
import com.chibbis.base_feature.R

class StandardMessageController(
    private val activeActivityHolder: ActiveActivityHolder,
    private val appContext: Context
) : MessageController {

    private var toast: Toast? = null
    private var snackBar: Snackbar? = null

    override fun showToast(message: String, gravity: Int, duration: Int) {
        toast?.cancel()
        toast = Toast.makeText(appContext, message, duration)
            .apply {
                setGravity(gravity, 0, 0)
                show()
            }
    }

    override fun showToast(stringId: Int, gravity: Int, duration: Int) {
        showToast(appContext.resources.getString(stringId), gravity, duration)
    }

    override fun showSnack(stringId: Int, duration: Int) {
        showSnack(appContext.resources.getString(stringId), duration)
    }

    override fun showSnack(message: String, duration: Int) {
        snackBar?.dismiss()
        getView()?.let {
            snackBar = Snackbar.make(it, message, duration).setAnchorView(getSnackAnchorView()).also {
                it.show()
            }
        }
    }

    private fun getView(): View? {
        val activity = activeActivityHolder.activity
        return activity?.findViewById(R.id.coordinator)
            ?: activity?.findViewById(android.R.id.content)
    }

    private fun getSnackAnchorView(): View? {
        return activeActivityHolder.activity?.run {
            (window?.decorView as? ViewGroup)?.findViewWithTag(getString(R.string.snackbar_anchor_tag))
        }
    }
}