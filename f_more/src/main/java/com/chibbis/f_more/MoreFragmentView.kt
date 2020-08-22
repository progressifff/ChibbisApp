package com.chibbis.f_more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.chibbis.base_feature.ui.view.BaseFragmentView
import com.chibbis.f_more.databinding.FragmentMoreBinding
import kotlinx.android.synthetic.main.fragment_more.*

/**
 * Фрагмент ещё
 */
class MoreFragmentView : BaseFragmentView<MoreViewModel>() {

    override val viewModelClass = MoreViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_more

    override fun createRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentMoreBinding>(
        layoutInflater, getContentView(), container, false
    ).apply {
        lifecycleOwner = this@MoreFragmentView
        viewModel = this@MoreFragmentView.viewModel
    }.root

    override fun onRootViewCreated() {
        more_app_rate_dialog_btn.setOnClickListener {
            findNavController().navigate(R.id.moreRateDialog)
        }
    }
}