package com.chibbis.base_feature.ui.view

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.isInvisible
import androidx.core.widget.addTextChangedListener
import com.chibbis.base.mappers.nonNull
import com.chibbis.base_feature.R
import kotlinx.android.synthetic.main.view_search.view.*

/**
 * Вью поиска
 */
class SearchView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null
) : LinearLayout(context, attributeSet) {

    init {
        View.inflate(context, R.layout.view_search, this)
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        initListeners()
    }

    fun addQueryTextWatcher(watcher: TextWatcher) {
        search_et.addTextChangedListener(watcher)
    }

    private fun initListeners() {
        search_et.addTextChangedListener {
            val query = it?.toString().nonNull
            search_clear_btn.isInvisible = query.isEmpty()
        }
        search_clear_btn.setOnClickListener { search_et.setText("") }
    }
}