package com.chibbis.f_restaurants

import android.os.Bundle
import android.view.View
import com.chibbis.base_feature.ui.view.BaseFragmentView

/**
 * Фрагмент ресторанов
 */
class RestaurantsFragmentView : BaseFragmentView<RestaurantsViewModel>() {

    override val viewModelClass = RestaurantsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_restaurants

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