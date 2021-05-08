package com.example.infrastructure.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecificationResponse {

    @SerializedName("fund_main_strategy_name")
    private String fundMainStrategyName;

    @SerializedName("fund_suitability_profile")
    private FundSuitabilityProfile fundSuitabilityProfile;

    @SerializedName("fund_risk_profile")
    private FundRiskProfile fundRiskProfile;

    @SerializedName("fund_main_strategy_explanation")
    private String fundMainStrategyExplanation;

    @SerializedName("fund_type")
    private String fundType;

    @SerializedName("fund_class")
    private String fundClass;

    @SerializedName("fund_macro_strategy")
    private FundMacroStrategy fundMacroStrategy;

    @SerializedName("fund_class_anbima")
    private String fundClassAnbima;

    @SerializedName("fund_main_strategy")
    private FundMainStrategy fundMainStrategy;

    @SerializedName("is_qualified")
    private String isQualified;

    public SpecificationResponse(
            String fundMainStrategyName,
            FundSuitabilityProfile fundSuitabilityProfile,
            String fundClass,
            String fundClassAnbima
    ) {
        this.fundMainStrategyName = fundMainStrategyName;
        this.fundSuitabilityProfile = fundSuitabilityProfile;
        this.fundClass = fundClass;
        this.fundClassAnbima = fundClassAnbima;
    }

    public String getFundMainStrategyName() {
        return fundMainStrategyName;
    }

    public FundSuitabilityProfile getFundSuitabilityProfile() {
        return fundSuitabilityProfile;
    }

    public FundRiskProfile getFundRiskProfile() {
        return fundRiskProfile;
    }

    public String getFundMainStrategyExplanation() {
        return fundMainStrategyExplanation;
    }

    public String getFundType() {
        return fundType;
    }

    public String getFundClass() {
        return fundClass;
    }

    public FundMacroStrategy getFundMacroStrategy() {
        return fundMacroStrategy;
    }

    public String getFundClassAnbima() {
        return fundClassAnbima;
    }

    public FundMainStrategy getFundMainStrategy() {
        return fundMainStrategy;
    }

    public String getIsQualified() {
        return isQualified;
    }

}
