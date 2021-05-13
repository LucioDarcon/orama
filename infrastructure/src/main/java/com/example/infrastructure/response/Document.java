package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class Document {

    @SerializedName("position")
    private String position;

    @SerializedName("document_type")
    private String documentType;

    @SerializedName("name")
    private String name;

    @SerializedName("document_url")
    private String documentUrl;

    public String getPosition() {
        return position;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getName() {
        return name;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

}
