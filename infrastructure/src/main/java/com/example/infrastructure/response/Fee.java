package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class Fee {

    @SerializedName("maximum_administration_fee")
    private String mMaximumAdministrationFee;

    @SerializedName("anticipated_retrieval_fee_value")
    private String mAnticipatedRetrievalFeeValue;

    @SerializedName("administration_fee")
    private String mAdministrationFee;

    @SerializedName("anticipated_retrieval_fee")
    private String mAnticipatedRetrievalFee;

    @SerializedName("performance_fee")
    private String mPerformanceFee;

    @SerializedName("has_anticipated_retrieval")
    private Boolean mHasAnticipatedRetrieval;

    public Fee(String maximumAdministrationFee,
               String anticipatedRetrievalFeeValue,
               String administrationFee,
               String anticipatedRetrievalFee,
               String performanceFee) {
        this.mMaximumAdministrationFee     = maximumAdministrationFee;
        this.mAnticipatedRetrievalFeeValue = anticipatedRetrievalFeeValue;
        this.mAdministrationFee            = administrationFee;
        this.mAnticipatedRetrievalFee      = anticipatedRetrievalFee;
        this.mPerformanceFee               = performanceFee;
    }

    public String getMaximumAdministrationFee() {
        return mMaximumAdministrationFee;
    }

    public String getAnticipatedRetrievalFeeValue() {
        return mAnticipatedRetrievalFeeValue;
    }

    public String getAdministrationFee() {
        return mAdministrationFee;
    }

    public String getAnticipatedRetrievalFee() {
        return mAnticipatedRetrievalFee;
    }

    public String getPerformanceFee() {
        return mPerformanceFee;
    }

    public Boolean getHasAnticipatedRetrieval() {
        return mHasAnticipatedRetrieval;
    }
}
