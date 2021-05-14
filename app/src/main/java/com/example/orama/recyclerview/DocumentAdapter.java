package com.example.orama.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infrastructure.response.Document;
import com.example.infrastructure.response.Fund;
import com.example.orama.R;
import com.example.orama.databinding.DocumentRecyclerItemBinding;
import com.example.orama.databinding.FundRecyclerItemBinding;
import com.example.orama.holder.DocumentViewHolder;
import com.example.orama.holder.FundViewHolder;

import java.util.ArrayList;
import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Document> mDocumentList = new ArrayList<>();
    private DocumentAdapterContract.View mView;
    private DocumentViewHolder mDocumentViewHolder;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DocumentRecyclerItemBinding documentRecyclerItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.document_recycler_item,
                parent,
                false);

        return new DocumentViewHolder(documentRecyclerItemBinding, mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        mDocumentViewHolder = (DocumentViewHolder) holder;
        Document document   = mDocumentList.get(position);
        mDocumentViewHolder.mDocumentViewHolderBinding.setDocument(document);
        mDocumentViewHolder.mDocumentViewHolderBinding.executePendingBindings();
    }

    public void submitList(List<Document> documents, DocumentAdapterContract.View view) {
        mDocumentList = documents;
        mView = view;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (mDocumentList == null) ? 0 : mDocumentList.size();
    }
}
