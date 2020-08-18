package com.chibbis.f_reviews

import android.os.Bundle
import android.view.View
import com.chibbis.base_feature.ui.view.BaseFragmentView

/**
 * Фрагмент отзывов
 */
class ReviewsFragmentView : BaseFragmentView<ReviewsViewModel>() {

    override val viewModelClass = ReviewsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_reviews

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