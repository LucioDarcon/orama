package com.example.orama.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infrastructure.response.Fund;
import com.example.orama.R;
import com.example.orama.databinding.FundRecyclerItemBinding;
import com.example.orama.holder.FundViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Fund> mFundList = new ArrayList<>();;
    private FundViewHolder mFundViewHolder;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FundRecyclerItemBinding fundRecyclerItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.fund_recycler_item,
                parent,
                false);

        return new FundViewHolder(fundRecyclerItemBinding);
    }

    public void filterByList(ArrayList<Fund> newFundList) {
        mFundList = newFundList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        mFundViewHolder = (FundViewHolder) holder;
        Fund fund       = mFundList.get(position);
        mFundViewHolder.mFundRecyclerItemBinding.setFund(fund);
        mFundViewHolder.mFundRecyclerItemBinding.executePendingBindings();
    }

    public void submitList(List<Fund> fundList) {
        mFundList = fundList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mFundList.size();
    }
}
