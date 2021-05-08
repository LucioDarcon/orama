package com.example.orama.ui;

import androidx.annotation.NonNull;

import com.example.infrastructure.callback.GetFundListCallBack;
import com.example.infrastructure.remotedatasource.FundRemoteDataSource;
import com.example.infrastructure.response.Fund;

import java.util.List;

public class MainFragmentPresenter implements MainFragmentContract.Presenter {

    FundRemoteDataSource mFundRemoteDataSource;

    public MainFragmentPresenter(@NonNull MainFragmentContract.View view,
                                 @NonNull FundRemoteDataSource fundRemoteDataSource){
        view.setPresenter(this);
        this.mFundRemoteDataSource = fundRemoteDataSource;
    }

    @Override
    public void getFund() {
        mFundRemoteDataSource.getFundApiList(new GetFundListCallBack() {
            @Override
            public void getFundListSuccess(List<Fund> fundList) {
                String a = "";
            }

            @Override
            public void getFundListFailure(Throwable throwable) {
                String b = "";
            }
        });
    }
}
