package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class FundSuitabilityProfile {

    @SerializedName("score_range_order")
    private Integer scoreRangeOrder;

    @SerializedName("name")
    private String name;

    public FundSuitabilityProfile(String name) {
        this.name = name;
    }

    public Integer getScoreRangeOrder() {
        return scoreRangeOrder;
    }

    public String getName() {
        return name;
    }

}
