package com.chibbis.f_reviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chibbis.base_feature.ui.recycler.HorizontalDividerDecoration
import com.chibbis.base_feature.ui.view.BaseFragmentView
import com.chibbis.f_reviews.databinding.FragmentReviewsBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_reviews.*

/**
 * Фрагмент отзывов
 */
class ReviewsFragmentView : BaseFragmentView<ReviewsViewModel>() {

    override val viewModelClass = ReviewsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_reviews

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentReviewsBinding>(
            layoutInflater, getContentView(), container, false
        )
        return binding.apply {
            binding.lifecycleOwner = this@ReviewsFragmentView
            viewModel = this@ReviewsFragmentView.viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        reviews_rv.apply {
            adapter = GroupAdapter<GroupieViewHolder>()
            addItemDecoration(
                HorizontalDividerDecoration(
                    context = requireContext(),
                    marginStart = R.dimen.review_divider_left_margin
                )
            )
        }
    }
}