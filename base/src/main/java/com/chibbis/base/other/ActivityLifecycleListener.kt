package com.chibbis.base.other

import android.app.Activity
import android.app.Application
import android.os.Bundle

class ActivityLifecycleListener(
    val onActivityPaused: ((activity: Activity) -> Unit)? = null,
    val onActivityStarted: ((activity: Activity) -> Unit)? = null,
    val onActivityDestroyed: ((activity: Activity) -> Unit)? = null,
    val onActivitySaveInstanceState: ((activity: Activity, bundle: Bundle) -> Unit)? = null,
    val onActivityStopped: ((activity: Activity) -> Unit)? = null,
    val onActivityCreated: ((activity: Activity, bundle: Bundle?) -> Unit)? = null,
    val onActivityResumed: ((activity: Activity) -> Unit)? = null
) : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) {
        onActivityPaused?.invoke(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        onActivityStarted?.invoke(activity)
    }

    override fun onActivityDestroyed(activity: Activity) {
        onActivityDestroyed?.invoke(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
        onActivitySaveInstanceState?.invoke(activity, bundle)
    }

    override fun onActivityStopped(activity: Activity) {
        onActivityStopped?.invoke(activity)
    }

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
        onActivityCreated?.invoke(activity, bundle)
    }

    override fun onActivityResumed(activity: Activity) {
        onActivityResumed?.invoke(activity)
    }
}