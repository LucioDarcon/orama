package com.example.orama.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.orama.R;
import com.example.orama.databinding.MainFragmentBinding;
import com.example.orama.recyclerview.FundAdapter;

import static com.example.core.provider.ProvideRemoteDataSource.provideFundRemoteDataSource;

public class MainFragment extends Fragment implements MainFragmentContract.View {

    FundAdapter mFundAdapter;
    MainFragmentBinding mMainFragmentBinding;
    MainFragmentPresenter mMainFragmentPresenter;

    public static MainFragment newInstance() {
        Bundle args           = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMainFragmentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.main_fragment,
                null,
                false
        );

        mMainFragmentPresenter = new MainFragmentPresenter(
                this,
                provideFundRemoteDataSource()
        );
        initAdapter();
        mMainFragmentPresenter.getFund();
        return mMainFragmentBinding.getRoot();
    }

    private void initAdapter() {
        mFundAdapter = new FundAdapter();
        mMainFragmentBinding.mainFragmentRecyclerViewFund.setAdapter(mFundAdapter);
        mMainFragmentBinding.mainFragmentRecyclerViewFund.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setPresenter(MainFragmentPresenter mainFragmentPresenter) {
        this.mMainFragmentPresenter = mainFragmentPresenter;
    }

}
