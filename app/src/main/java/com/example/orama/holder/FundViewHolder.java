package com.example.orama.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orama.databinding.FundRecyclerItemBinding;
import com.example.orama.recyclerview.FundAdapterContract;

public class FundViewHolder extends RecyclerView.ViewHolder {

    public FundRecyclerItemBinding mFundRecyclerItemBinding;

    public FundViewHolder(@NonNull FundRecyclerItemBinding fundRecyclerItemBinding, FundAdapterContract.View view) {
        super(fundRecyclerItemBinding.getRoot());
        this.mFundRecyclerItemBinding = fundRecyclerItemBinding;
        this.mFundRecyclerItemBinding.fundRecyclerItemCardView.setOnClickListener(v -> view.onClickFund(mFundRecyclerItemBinding.getFund()));
    }


}
