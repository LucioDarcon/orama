package com.example.orama.recyclerview;

import com.example.infrastructure.response.Document;

public interface DocumentAdapterContract {

    interface View {
        void onClickDocument(Document document);
    }

}
