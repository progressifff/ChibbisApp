package com.chibbis.f_reviews.di

import androidx.lifecycle.ViewModel
import com.chibbis.base.scope.FragmentScope
import com.chibbis.base_feature.di.ViewModelKey
import com.chibbis.f_reviews.ReviewsFragmentView
import com.chibbis.f_reviews.ReviewsViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ReviewsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun contributeReviewsFragmentInjector(): ReviewsFragmentView

    @Binds
    @IntoMap
    @ViewModelKey(ReviewsViewModel::class)
    internal abstract fun reviewsViewModel(reviewsViewModel: ReviewsViewModel): ViewModel
}