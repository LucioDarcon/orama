package com.example.orama.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orama.databinding.DocumentRecyclerItemBinding;
import com.example.orama.recyclerview.DocumentAdapterContract;

public class DocumentViewHolder extends RecyclerView.ViewHolder {

    public DocumentRecyclerItemBinding mDocumentViewHolderBinding;

    public DocumentViewHolder(@NonNull DocumentRecyclerItemBinding documentRecyclerItemBinding, DocumentAdapterContract.View view) {
        super(documentRecyclerItemBinding.getRoot());
        this.mDocumentViewHolderBinding = documentRecyclerItemBinding;
        this.mDocumentViewHolderBinding.documentRecyclerViewItemImageView.setOnClickListener(v -> view.onClickDocument(mDocumentViewHolderBinding.getDocument()));
    }

}
