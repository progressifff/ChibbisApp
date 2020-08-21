package com.chibbis.f_more.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.chibbis.base_feature.consts.EMPTY_STRING
import com.chibbis.domain.app_rate.AppRate
import com.chibbis.f_more.R
import kotlinx.android.synthetic.main.dialog_app_rate_chooser.*

/**
 * Диалог выбора оценки приложения.
 */
class AppRateDialogView : DialogFragment() {

    private var chosenRate: AppRate = AppRate.UNKNOWN

    private val rateAppButtonClickListener = View.OnClickListener {
        dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.dialog_app_rate_chooser, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    override fun getTheme(): Int = R.style.NoTitleDialog

    private fun initViews() {
        app_rate_dialog_rate_view.onRateChangedAction = { starPlace ->
            handleRateChangedAction(starPlace)
        }

        app_rate_dialog_close_ib.setOnClickListener {
            dismiss()
        }

        app_rate_dialog_rate_btn.setOnClickListener(rateAppButtonClickListener)
    }

    private fun handleRateChangedAction(starValue: Int) {
        chosenRate = AppRate.getByStarValue(starValue)
        dialog?.app_rate_dialog_rate_tv?.text = getRateText(chosenRate)
    }

    private fun getRateText(rate: AppRate): String? {
        val rateTextRes = when (rate) {
            AppRate.AWFUL -> R.string.app_rate_one_star_text
            AppRate.BAD -> R.string.app_rate_two_stars_text
            AppRate.SATISFACTORY -> R.string.app_rate_three_stars_text
            AppRate.GOOD -> R.string.app_rate_four_stars_text
            AppRate.GREAT -> R.string.app_rate_five_stars_text
            else -> null
        } ?: return EMPTY_STRING
        return getString(rateTextRes)
    }
}