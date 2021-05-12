package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class FundSituation {

    @SerializedName("code")
    private String code;

    @SerializedName("name")
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
