package com.example.orama.ui.presenter;

import androidx.annotation.NonNull;

import com.example.infrastructure.callback.GetFundListCallBack;
import com.example.infrastructure.remotedatasource.FundRemoteDataSource;
import com.example.infrastructure.response.Fund;
import com.example.orama.ui.contracts.MainFragmentContract;

import java.util.List;

public class MainFragmentPresenter implements MainFragmentContract.Presenter {

    FundRemoteDataSource mFundRemoteDataSource;
    MainFragmentContract.View mView;

    public MainFragmentPresenter(@NonNull MainFragmentContract.View view,
                                 @NonNull FundRemoteDataSource fundRemoteDataSource){
        view.setPresenter(this);
        this.mFundRemoteDataSource = fundRemoteDataSource;
        this.mView = view;
    }

    @Override
    public void getFund() {
        mFundRemoteDataSource.getFundApiList(new GetFundListCallBack() {
            @Override
            public void getFundListSuccess(List<Fund> fundList) {
                mView.showFundList(fundList);
            }

            @Override
            public void getFundListFailure(Throwable throwable) {
                throwable.printStackTrace();
                mView.errorToGetFundList();
            }

        });
    }
}
