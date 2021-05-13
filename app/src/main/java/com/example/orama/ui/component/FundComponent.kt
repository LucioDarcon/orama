package com.example.orama.ui.component

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.infrastructure.response.Fund
import com.example.orama.R
import com.example.orama.databinding.FundItemComponentBinding

class FundComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private var fundItemComponentBinding: FundItemComponentBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context), R.layout.fund_item_component, this, true
        )

    fun setFund(fund: Fund?) {
        fundItemComponentBinding.fund = fund
        fundItemComponentBinding.executePendingBindings()
    }

    fun getFund(): Fund? {
        return fundItemComponentBinding.fund
    }

}