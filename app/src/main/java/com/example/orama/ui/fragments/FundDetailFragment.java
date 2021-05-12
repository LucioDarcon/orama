package com.example.orama.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.core.BuildConfig;
import com.example.infrastructure.response.Document;
import com.example.infrastructure.response.Fund;
import com.example.orama.R;
import com.example.orama.databinding.FundDetailFragmentBinding;
import com.example.orama.recyclerview.DocumentAdapter;
import com.example.orama.recyclerview.DocumentAdapterContract;
import com.example.orama.recyclerview.FundAdapter;
import com.example.orama.ui.activities.MainActivity;

import java.util.Objects;

public class FundDetailFragment extends Fragment implements DocumentAdapterContract.View {

    FundDetailFragmentBinding mFundDetailFragmentBinding;
    Fund mFund;
    DocumentAdapter mDocumentAdapter;

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

        initAdapter();
        setListDocument();
        configureImageView();
        configureFragments();
        changeTitleActionBar();

        mFundDetailFragmentBinding.setFund(mFund);
        mFundDetailFragmentBinding.executePendingBindings();
        return mFundDetailFragmentBinding.getRoot();
    }

    private void changeTitleActionBar() {
        ((MainActivity) requireActivity()).changeTitleActionBar("Fund detail");
    }

    private void initAdapter() {
        mDocumentAdapter = new DocumentAdapter();
        mFundDetailFragmentBinding.fundDetailFragmentDocumentRecyclerView.setAdapter(mDocumentAdapter);
        mFundDetailFragmentBinding.fundDetailFragmentDocumentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void setListDocument() {
        mDocumentAdapter.submitList(mFund.getDocumentRespons(), this);
    }


    public void configureFragments() {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_specification,
                        SpecificationFragment.newInstance(mFund)
                ).commit();

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fees,
                        FeesFragment.newInstance(mFund)
                ).commit();
    }

    public void configureImageView() {
        Glide.with(this).load(BuildConfig.BASE_URL + mFund.getFundManager()
                                        .getLogo())
                                        .into(mFundDetailFragmentBinding.fundDetailFragmentFundManagerPhoto);
    }


    @Override
    public void onClickDocument(Document document) {
        createAlertDialog(document);
    }

    private void createAlertDialog(Document document) {
        AlertDialog.Builder downloadDocumentAlert = new AlertDialog.Builder(getContext());
        downloadDocumentAlert.setMessage(requireContext().getString(R.string.alert_dialog_download_message));
        downloadDocumentAlert.setPositiveButton(
                requireContext().getString(R.string.alert_dialog_download_message_download),
                (dialog, id) -> goToPdfFragment(document));

        downloadDocumentAlert.setNegativeButton(
                requireContext().getString(R.string.alert_dialog_download_message_no),
                (dialog, id) -> dialog.cancel());
        downloadDocumentAlert.create().show();
    }

    public void goToPdfFragment(Document document) {
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,
                        PdfFragment.newInstance(document.getDocumentUrl())
                ).addToBackStack("PdfFragment").commit();
    }

}
