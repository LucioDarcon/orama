package com.example.orama.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.infrastructure.response.Fund;
import com.example.orama.R;
import com.example.orama.databinding.FundDetailFragmentBinding;
public class FundDetailFragment extends Fragment {

    FundDetailFragmentBinding mFundDetailFragmentBinding;
    Fund mFund;

    public static FundDetailFragment newInstance(Fund fund) {
        Bundle args = new Bundle();
        FundDetailFragment fragment = new FundDetailFragment(fund);
        fragment.setArguments(args);
        return fragment;
    }

    public FundDetailFragment(Fund fund) {
        this.mFund = fund;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFundDetailFragmentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.fund_detail_fragment,
                null,
                false
        );

        configureExpandableLayouts();
        mFundDetailFragmentBinding.setFund(mFund);
        mFundDetailFragmentBinding.executePendingBindings();

        return mFundDetailFragmentBinding.getRoot();
    }

    public void configureExpandableLayouts() {
        mFundDetailFragmentBinding.fundDetailFragmentFeesTextView.setOnClickListener(v -> mFundDetailFragmentBinding.fundDetailFragmentFeesExpandableLayout.setExpanded(!mFundDetailFragmentBinding.fundDetailFragmentFeesExpandableLayout.isExpanded()));
        mFundDetailFragmentBinding.fundDetailFragmentSpecificationTextView.setOnClickListener(v -> mFundDetailFragmentBinding.fundDetailFragmentSpecificationExpandableLayout.setExpanded(!mFundDetailFragmentBinding.fundDetailFragmentSpecificationExpandableLayout.isExpanded()));
        mFundDetailFragmentBinding.fundDetailFragmentFundManagerTextView.setOnClickListener(v -> mFundDetailFragmentBinding.fundDetailFragmentFundManageExpandableLayout.setExpanded(!mFundDetailFragmentBinding.fundDetailFragmentFundManageExpandableLayout.isExpanded()));
        Glide.with(this).load("https://s3.amazonaws.com/orama-media/" + mFund.getFundManager().getLogo()).into(mFundDetailFragmentBinding.fundDetailFragmentFundManagerPhoto);
    }


}
