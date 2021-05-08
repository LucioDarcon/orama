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

import com.example.core.service.FundApiDataSource;
import com.example.orama.R;
import com.example.orama.databinding.MainFragmentBinding;
import com.example.orama.recyclerview.FundAdapter;

public class MainFragment extends Fragment {

    FundAdapter fundAdapter;
    MainFragmentBinding mainFragmentBinding;
    private FundApiDataSource fundApiDataSource;

    public static MainFragment newInstance() {
        Bundle args           = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainFragmentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.main_fragment,
                null,
                false
        );

        initAdapter();
        getFunds();

        return mainFragmentBinding.getRoot();
    }

    private void initAdapter() {
        fundAdapter = new FundAdapter();
        mainFragmentBinding.mainFragmentRecyclerViewFund.setAdapter(fundAdapter);
        mainFragmentBinding.mainFragmentRecyclerViewFund.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void getFunds() {

    }


}
