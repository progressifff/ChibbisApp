package com.chibbis.f_restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chibbis.base_feature.ui.text.DebounceTextChangedListener
import com.chibbis.base_feature.ui.view.BaseFragmentView
import com.chibbis.f_restaurants.databinding.FragmentRestaurantsBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_restaurants.*

/**
 * Фрагмент ресторанов
 */
class RestaurantsFragmentView : BaseFragmentView<RestaurantsViewModel>() {

    override val viewModelClass = RestaurantsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_restaurants

    override fun createRootView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentRestaurantsBinding>(
        layoutInflater, getContentView(), container, false
    ).apply {
        lifecycleOwner = this@RestaurantsFragmentView
        viewModel = this@RestaurantsFragmentView.viewModel
    }.root

    override fun onRootViewCreated() {
        initViews()
    }

    private fun initViews() {
        restaurants_rv.adapter = GroupAdapter<GroupieViewHolder>()
        restaurants_search_view.addQueryTextWatcher(
            DebounceTextChangedListener(
                lifecycleOwner = this,
                onTextChanged = { viewModel.onRestaurantSearch(it) }
            )
        )
    }
}