package com.chibbis.f_main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.chibbis.base_feature.ui.view.BaseActivityView
import kotlinx.android.synthetic.main.activity_main_view.*

/**
 * Вью активити главного экрана
 */
class MainActivityView : BaseActivityView<MainViewModel>() {

    override val viewModelClass = MainViewModel::class.java

    override fun getContentView(): Int = R.layout.activity_main_view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val navigationController = findNavController(R.id.main_host_fragment)
        main_navigation_view.apply {
            val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.restaurantsFragmentView, R.id.reviewsFragmentView, R.id.launchDetailsFragmentView))
            //setupActionBarWithNavController(navigationController, appBarConfiguration)
            setupWithNavController(navigationController)
        }
    }
}

