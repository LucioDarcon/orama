package com.example.orama.ui.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.infrastructure.response.Fund;
import com.example.orama.R;
import com.example.orama.databinding.MainFragmentBinding;
import com.example.orama.recyclerview.FundAdapter;
import com.example.orama.recyclerview.FundAdapterContract;
import com.example.orama.ui.activities.MainActivity;
import com.example.orama.ui.contracts.MainFragmentContract;
import com.example.orama.ui.presenter.MainFragmentPresenter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.core.provider.ProvideRemoteDataSource.provideFundRemoteDataSource;

public class MainFragment extends Fragment implements MainFragmentContract.View, View.OnClickListener, FundAdapterContract.View {

    FundAdapter mFundAdapter;
    MainFragmentBinding mMainFragmentBinding;
    MainFragmentPresenter mMainFragmentPresenter;
    List<Fund> mCurrentFundList = new ArrayList<>();

    public static MainFragment newInstance() {
        Bundle args           = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMainFragmentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.main_fragment,
                null,
                false
        );
        setListeners();
        initAdapter();
        initPresenter();
        filterList();
        changeTitleActionBar();
        return mMainFragmentBinding.getRoot();
    }

    public void initPresenter() {
        mMainFragmentPresenter = new MainFragmentPresenter(
                this,
                provideFundRemoteDataSource()
        );
        mMainFragmentPresenter.getFund();
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

    @Override
    public void showFundList(List<Fund> fundList) {
        mCurrentFundList = fundList;
        mFundAdapter.submitList(fundList, this);
    }

    private void changeTitleActionBar() {
        ((MainActivity) requireActivity()).changeTitleActionBar("Fund list");
    }

    public void filterList() {
        mMainFragmentBinding.mainFragmentSearchFundEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                getFundFilter(editable.toString());
            }
        });
    }

    public void getFundFilter(String text) {
        ArrayList<Fund> newFundList = new ArrayList<>();

        for (Fund filterFund : mCurrentFundList) {
            if (filterFund.getSimpleName().toLowerCase().contains(text.toLowerCase())) {
                newFundList.add(filterFund);
            }
        }
        mFundAdapter.submitList(newFundList, this);
    }

    @Override
    public void errorToGetFundList() {
        Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG ).show();
    }

    @Override
    public void showProgressBar() {
        mMainFragmentBinding.mainFragmentProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mMainFragmentBinding.mainFragmentProgressBar.setVisibility(View.GONE);
    }

    public void setListeners() {
        mMainFragmentBinding.mainFragmentSearchFloatActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_fragment_search_float_action_button:
                mMainFragmentBinding.mainFragmentSearchFundEditText.setVisibility(
                        (mMainFragmentBinding.mainFragmentSearchFundEditText.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClickFund(Fund fund) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,
                        FundDetailFragment.newInstance(fund)
                ).addToBackStack("FundDetailFragment").commit();
    }

}
