package com.example.orama.holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orama.databinding.FundRecyclerItemBinding;

public class FundViewHolder extends RecyclerView.ViewHolder {

    public FundRecyclerItemBinding mFundRecyclerItemBinding;

    public FundViewHolder(@NonNull FundRecyclerItemBinding fundRecyclerItemBinding) {
        super(fundRecyclerItemBinding.getRoot());
        this.mFundRecyclerItemBinding = fundRecyclerItemBinding;
    }


}
