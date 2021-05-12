package com.example.orama.ui.presenter;

import androidx.annotation.NonNull;

import com.example.infrastructure.callback.GetPdfCallBack;
import com.example.infrastructure.remotedatasource.FundRemoteDataSource;
import com.example.orama.ui.contracts.PdfFragmentContract;

import java.io.File;

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
    public void getPdfDocument(String url) {
        mView.loadProgressBar();
        mFundRemoteDataSource.getPDF(new GetPdfCallBack() {
            @Override
            public void getPdtSuccess(File file) {
                mView.showFile(file);
                mView.hideProgressBar();
            }

            @Override
            public void getPdfFailure(Throwable throwable) {
                mView.error();
            }
        }, url);

    }

}
