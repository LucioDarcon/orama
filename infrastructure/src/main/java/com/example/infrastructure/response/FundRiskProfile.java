package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class FundRiskProfile {

    @SerializedName("score_range_order")
    private String scoreRangeOrder;

    @SerializedName("name")
    private String name;

    public String getScoreRangeOrder() {
        return scoreRangeOrder;
    }

    public String getName() {
        return name;
    }

}
