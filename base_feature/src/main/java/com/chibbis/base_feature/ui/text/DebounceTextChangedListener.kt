package com.chibbis.base_feature.ui.text

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val DEFAULT_DEBOUNCE_PERIOD = 500L

/**
 * Text listener with debounce
 * @property lifecycleOwner Owner
 * @property debounce Time millis
 * @property onTextChanged Listener ot new text
 */
class DebounceTextChangedListener(
    private val lifecycleOwner: LifecycleOwner,
    private val debounce: Long = DEFAULT_DEBOUNCE_PERIOD,
    private val onTextChanged: (String) -> Unit
) : TextWatcher {

    private var searchJob: Job? = null

    override fun afterTextChanged(p0: Editable?) {}

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
        searchJob?.cancel()
        searchJob = lifecycleOwner.lifecycleScope.launch {
            delay(debounce)
            onTextChanged(text.toString())
        }
    }
}