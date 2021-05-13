package com.example.orama.ui.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.infrastructure.response.Fund;
import com.example.orama.R;
import com.example.orama.databinding.FeesFragmentBinding;

import static com.example.orama.util.ExpandableUtil.configExpandableLayout;

public class FeesFragment extends Fragment {

    FeesFragmentBinding mFeesFragmentBinding;
    Fund mFund;

    public static FeesFragment newInstance(Fund fund) {
        Bundle args = new Bundle();
        FeesFragment fragment = new FeesFragment(fund);
        fragment.setArguments(args);
        return fragment;
    }

    public FeesFragment(Fund fund) {
        mFund = fund;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFeesFragmentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(getContext()),
                R.layout.fees_fragment,
                null,
                false
        );

        mFeesFragmentBinding.setFund(mFund);
        configureExpandableLayout();

        configExpandableLayout(getActivity(),
                               mFeesFragmentBinding.fundDetailFragmentFeesExpandableButton,
                               mFeesFragmentBinding.fundDetailFragmentFeesExpandableLayout);

        return mFeesFragmentBinding.getRoot();
    }

    private void configureExpandableLayout() {
        Drawable expandLessDrawable = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_baseline_expand_less_24);
        Drawable expandMoreDrawable = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_baseline_expand_more_24);
        mFeesFragmentBinding.fundDetailFragmentFeesExpandableButton.setOnClickListener(v -> {
            boolean specificationExpandableLayoutIsExpanded = mFeesFragmentBinding.fundDetailFragmentFeesExpandableLayout.isExpanded();

            mFeesFragmentBinding.fundDetailFragmentFeesExpandableLayout.setExpanded(!specificationExpandableLayoutIsExpanded);

            if (specificationExpandableLayoutIsExpanded) {
                mFeesFragmentBinding.fundDetailFragmentFeesExpandableButton.setImageDrawable(expandMoreDrawable);
            } else {
                mFeesFragmentBinding.fundDetailFragmentFeesExpandableButton.setImageDrawable(expandLessDrawable);
            }

        });
    }

}
