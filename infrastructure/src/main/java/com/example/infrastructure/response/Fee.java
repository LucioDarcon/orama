package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class Fee {

    @SerializedName("maximum_administration_fee")
    private String maximumAdministrationFee;

    @SerializedName("anticipated_retrieval_fee_value")
    private String anticipatedRetrievalFeeValue;

    @SerializedName("administration_fee")
    private String administrationFee;

    @SerializedName("anticipated_retrieval_fee")
    private String anticipatedRetrievalFee;

    @SerializedName("performance_fee")
    private String performanceFee;

    @SerializedName("has_anticipated_retrieval")
    private Boolean hasAnticipatedRetrieval;

    public String getMaximumAdministrationFee() {
        return maximumAdministrationFee;
    }

    public String getAnticipatedRetrievalFeeValue() {
        return anticipatedRetrievalFeeValue;
    }

    public String getAdministrationFee() {
        return administrationFee;
    }

    public String getAnticipatedRetrievalFee() {
        return anticipatedRetrievalFee;
    }

    public String getPerformanceFee() {
        return performanceFee;
    }

    public Boolean getHasAnticipatedRetrieval() {
        return hasAnticipatedRetrieval;
    }


}
