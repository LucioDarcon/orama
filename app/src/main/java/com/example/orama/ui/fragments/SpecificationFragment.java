package com.example.orama.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.infrastructure.response.Fund;
import com.example.orama.R;
import com.example.orama.databinding.SpecificationFragmentBinding;

public class SpecificationFragment extends Fragment {

    SpecificationFragmentBinding mSpecificationFragment;
    Fund mFund;

    public static SpecificationFragment newInstance(Fund fund) {
        Bundle args = new Bundle();
        SpecificationFragment fragment = new SpecificationFragment(fund);
        fragment.setArguments(args);
        return fragment;
    }

    public SpecificationFragment(Fund fund) {
        mFund = fund;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mSpecificationFragment = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.specification_fragment,
                null,
                false
        );

        mSpecificationFragment.setFund(mFund);
        configureExpandableLayout();
        return mSpecificationFragment.getRoot();
    }

    private void configureExpandableLayout() {
        mSpecificationFragment.fundDetailFragmentSpecificationTextView.setOnClickListener(v ->
                mSpecificationFragment.fundDetailFragmentSpecificationExpandableLayout.setExpanded(
                !mSpecificationFragment.fundDetailFragmentSpecificationExpandableLayout.isExpanded())
        );
    }

}
