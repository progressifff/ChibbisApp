package com.chibbis.f_more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentMoreBinding>(
            layoutInflater, getContentView(), container, false
        )
        return binding.apply {
            binding.lifecycleOwner = this@MoreFragmentView
            viewModel = this@MoreFragmentView.viewModel
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        more_app_rate_dialog_btn.setOnClickListener {
            findNavController().navigate(R.id.moreRateDialog)
        }
    }
}