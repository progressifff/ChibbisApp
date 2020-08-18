package com.chibbis.f_hits

import android.os.Bundle
import android.view.View
import com.chibbis.base_feature.ui.view.BaseFragmentView

/**
 * Фрагмент хитов продаж
 */
class HitsFragmentView : BaseFragmentView<HitsViewModel>() {

    override val viewModelClass = HitsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_hits

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe()
    }

    private fun initViews() {

    }

    private fun observe() {

    }
}