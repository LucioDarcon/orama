package com.example.infrastructure.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FundMainStrategy {

    @SerializedName("explanation")
    private String explanation;

    @SerializedName("fund_macro_strategy")
    private Integer fundMacroStrategy;

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    public String getExplanation() {
        return explanation;
    }

    public Integer getFundMacroStrategy() {
        return fundMacroStrategy;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
