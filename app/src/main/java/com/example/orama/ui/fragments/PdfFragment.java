package com.example.orama.ui.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.infrastructure.response.Fund;
import com.example.orama.BuildConfig;
import com.example.orama.R;
import com.example.orama.databinding.PdfFragmentBinding;
import com.example.orama.ui.contracts.PdfFragmentContract;
import com.example.orama.ui.presenter.MainFragmentPresenter;
import com.example.orama.ui.presenter.PdfPresenter;
import com.example.orama.uitl.DownloadPdfFile;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.example.core.provider.ProvideRemoteDataSource.provideFundRemoteDataSource;

public class PdfFragment extends Fragment implements PdfFragmentContract.View {

    PdfFragmentBinding mPdfFragmentBinding;
    String mUrl;
    PdfPresenter mPdfPresenter;

    public static PdfFragment newInstance(String url) {
        Bundle args = new Bundle();
        PdfFragment fragment = new PdfFragment(url);
        fragment.setArguments(args);
        return fragment;
    }

    public PdfFragment(String url) {
        mUrl = url;
    }

    public void initPresenter() {
        mPdfPresenter = new PdfPresenter(
                this,
                provideFundRemoteDataSource()
        );
        mPdfPresenter.getFund(BuildConfig.BASE_URL + mUrl);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPdfFragmentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.pdf_fragment,
                null,
                false
        );

        initPresenter();

        return mPdfFragmentBinding.getRoot();
    }


    @Override
    public void setPresenter(PdfPresenter presenter) {
        mPdfPresenter = presenter;
    }

    @Override
    public void showFile(File file) {
        mPdfFragmentBinding.PDFView.fromFile(file).load();
    }

    @Override
    public void errorToGetFundList() {
        Toast.makeText(getContext(), "Fail :(", Toast.LENGTH_LONG).show();
    }
}
