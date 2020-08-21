package com.chibbis.f_hits

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chibbis.base.data.wrapper.LoadStatus
import com.chibbis.base.data.wrapper.LoadableData
import com.chibbis.base_feature.ui.recycler.RecyclerContent
import com.chibbis.base_feature.ui.recycler.RecyclerStubContent
import com.chibbis.base_feature.ui.viewmodel.BaseViewModel
import com.chibbis.domain.hit.Hit
import com.chibbis.f_hits.data.HitsBundleUi
import com.chibbis.i_hits.HitsInteractor
import kotlinx.coroutines.Job
import javax.inject.Inject

/**
 * Вью модель хитов продаж
 *
 * @property hitsInteractor Интерактор хитов продаж
 */
class HitsViewModel @Inject constructor(
    private val hitsInteractor: HitsInteractor
) : BaseViewModel() {

    private val hitsListMutableLiveData = MutableLiveData<RecyclerContent>()
    private val swrMutableLiveData = MutableLiveData<Boolean>()
    private val hitsStubContent = RecyclerStubContent(layoutRes = R.layout.item_hits_stub)
    private val hitsData = LoadableData(
        onMainLoading = ::reactToMainLoading,
        onSwrLoading = ::reactToSwrLoading,
        onDataReady = ::reactToHitsReady
    )
    private var loadHitsJob: Job? = null

    val restaurantsListLiveData: LiveData<RecyclerContent> = hitsListMutableLiveData
    val swrLiveData: LiveData<Boolean> = swrMutableLiveData
    var hitLargeImageObservable = ObservableField<Drawable?>()

    init {
        load()
    }

    fun onRefresh() {
        load(isSwr = true)
    }

    fun onHitIncreasedImageClicked() {
        hitLargeImageObservable.set(null)
    }

    private fun reactToMainLoading(isLoading: Boolean) {
        hitsListMutableLiveData.postValue(
            hitsStubContent.apply { this.isLoading = isLoading }
        )
    }

    private fun reactToSwrLoading(isLoading: Boolean) {
        swrMutableLiveData.postValue(isLoading)
    }

    private fun reactToHitsReady(hits: List<Hit>) {
        hitsListMutableLiveData.apply {
            when (val value = value) {
                is HitsBundleUi -> value.data = hits
                else -> postValue(HitsBundleUi(hits) { hitLargeImageObservable.set(it) })
            }
        }
    }

    private fun load(isSwr: Boolean = false) {
        loadHitsJob?.cancel()
        loadHitsJob = doWork(
            {
                hitsData.update(isSwr = isSwr, loadStatus = LoadStatus.LOADING)
                val hits = hitsInteractor.getHits()
                hitsData.update(data = hits, loadStatus = LoadStatus.NORMAL)
            },
            {
                hitsData.update(loadStatus = LoadStatus.ERROR)
            }
        )
    }
}