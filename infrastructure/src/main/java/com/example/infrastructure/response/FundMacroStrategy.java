package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class FundMacroStrategy {

    @SerializedName("id")
    private Integer id;

    @SerializedName("explanation")
    private String explanation;

    @SerializedName("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getName() {
        return name;
    }

}
