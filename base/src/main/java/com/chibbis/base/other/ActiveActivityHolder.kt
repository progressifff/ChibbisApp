package com.chibbis.base.other

import android.app.Activity

class ActiveActivityHolder {
    var activity: Activity? = null

    fun clear() {
        activity = null
    }
}