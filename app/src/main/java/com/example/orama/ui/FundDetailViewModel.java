package com.example.orama.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.orama.model.Fund;

public class FundDetailViewModel {

    private final MutableLiveData<Fund> mMutableFundDetail = new MutableLiveData<>();
    private final LiveData<Fund> mFundDetail = mMutableFundDetail;

    public LiveData<Fund> getFundDetailLiveData() {
        return mFundDetail;
    }

    public void setFundDetail(Fund fund) {
        mMutableFundDetail.setValue(fund);
    }

    public Fund getFundDetail() {
        return mFundDetail.getValue();
    }


}
