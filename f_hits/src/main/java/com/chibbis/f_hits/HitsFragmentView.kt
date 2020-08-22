package com.chibbis.f_hits

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.chibbis.base_feature.ui.view.BaseFragmentView
import com.chibbis.f_hits.databinding.FragmentHitsBinding
import com.chibbis.f_hits.view.IncreasedImageView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_hits.*

/**
 * Фрагмент хитов продаж
 */
class HitsFragmentView : BaseFragmentView<HitsViewModel>() {

    override val viewModelClass = HitsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_hits

    override fun createRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentHitsBinding>(
        layoutInflater, getContentView(), container, false
    ).apply {
        lifecycleOwner = this@HitsFragmentView
        viewModel = this@HitsFragmentView.viewModel
    }.root

    override fun onRootViewCreated() {
        initViews()
    }

    private fun initViews() {
        hits_rv.adapter = GroupAdapter<GroupieViewHolder>()
    }

    companion object {
        @BindingAdapter("app:image")
        @JvmStatic
        fun renderIncreasedImage(view: IncreasedImageView, drawable: Drawable?) {
            view.render(drawable)
        }
    }
}