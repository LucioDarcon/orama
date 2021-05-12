package com.example.orama.ui.presenter;

import androidx.annotation.NonNull;

import com.example.infrastructure.callback.GetFundListCallBack;
import com.example.infrastructure.callback.GetPdfCallBack;
import com.example.infrastructure.remotedatasource.FundRemoteDataSource;
import com.example.infrastructure.response.Fund;
import com.example.orama.ui.contracts.MainFragmentContract;
import com.example.orama.ui.contracts.PdfFragmentContract;

import java.io.File;
import java.util.List;

public class PdfPresenter implements PdfFragmentContract.Presenter {

    private PdfFragmentContract.View mView;
    private FundRemoteDataSource mFundRemoteDataSource;

    public PdfPresenter(@NonNull PdfFragmentContract.View view,
                        @NonNull FundRemoteDataSource fundRemoteDataSource) {

        view.setPresenter(this);
        mView = view;
        mFundRemoteDataSource = fundRemoteDataSource;
    }

    @Override
    public void getFund(String url) {
        mFundRemoteDataSource.getPDF(new GetPdfCallBack() {
            @Override
            public void getPdtSuccess(File file) {
                mView.showFile(file);
            }

            @Override
            public void getPdfFailure(Throwable throwable) {
                String a = "";
            }
        }, url);

    }
}
