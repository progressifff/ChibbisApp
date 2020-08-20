package com.chibbis.f_hits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chibbis.base_feature.ui.view.BaseFragmentView
import com.chibbis.f_hits.databinding.FragmentHitsBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_hits.*

/**
 * Фрагмент хитов продаж
 */
class HitsFragmentView : BaseFragmentView<HitsViewModel>() {

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override val viewModelClass = HitsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_hits

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentHitsBinding>(
            layoutInflater, getContentView(), container, false
        )
        return binding.apply {
            binding.lifecycleOwner = this@HitsFragmentView
            viewModel = this@HitsFragmentView.viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        hits_rv.adapter = groupAdapter
    }
}