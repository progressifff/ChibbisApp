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

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override val viewModelClass = RestaurantsViewModel::class.java

    override fun getContentView(): Int = R.layout.fragment_restaurants

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentRestaurantsBinding>(
            layoutInflater, getContentView(), container, false
        )
        return binding.apply {
            binding.lifecycleOwner = this@RestaurantsFragmentView
            viewModel = this@RestaurantsFragmentView.viewModel
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        restaurants_rv.adapter = groupAdapter
        restaurants_search_view.addQueryTextWatcher(
            DebounceTextChangedListener(
                lifecycleOwner = this,
                onTextChanged = { viewModel.onRestaurantSearch(it) }
            )
        )
    }
}