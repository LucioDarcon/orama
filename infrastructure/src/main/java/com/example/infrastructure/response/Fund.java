package com.example.infrastructure.response;

import com.example.infrastructure.uitl.MathUtils;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Fund {
    @SerializedName("id")
    protected Integer id;

    @SerializedName("fees")
    protected Fee fees;

    @SerializedName("is_simple")
    protected Boolean isSimple;

    @SerializedName("operability")
    protected Operability operability;

    @SerializedName("full_name")
    protected String fullName;

    @SerializedName("is_closed")
    protected Boolean isClosed;

    @SerializedName("simple_name")
    protected String simpleName;

    @SerializedName("documents")
    protected ArrayList<Document> documentRespons;

    @SerializedName("specification")
    protected Specification specification;

    @SerializedName("quota_date")
    protected Date quotaDate;

    @SerializedName("tax_classification")
    protected String taxClassification;

    @SerializedName("description")
    protected Description description;

    @SerializedName("is_active")
    protected Boolean isActive;

    @SerializedName("fund_situation")
    protected FundSituation fundSituation;

    @SerializedName("volatility_12m")
    protected String volatility12m;

    @SerializedName("profitabilities")
    protected Profitabilities profitabilities;

    @SerializedName("net_patrimony_12m")
    protected String netPatrimony12M;

    @SerializedName("fund_manager")
    protected FundManager fundManager;

    public Fund(
            Boolean isSimple,
            Operability operability,
            String simpleName,
            Specification specification,
            Description description,
            String volatility12m,
            Profitabilities profitabilities,
            FundManager fundManager
    ) {
        this.isSimple = isSimple;
        this.operability = operability;
        this.simpleName = simpleName;
        this.specification = specification;
        this.description = description;
        this.volatility12m = volatility12m;
        this.profitabilities = profitabilities;
        this.fundManager = fundManager;
    }

    public Integer getId() {
        return id;
    }

    public Fee getFees() {
        return fees;
    }

    public Boolean getIsSimple() {
        return isSimple;
    }

    public Operability getOperability() {
        return operability;
    }

    public String getFullName() {
        return fullName;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public ArrayList<Document> getDocumentRespons() {
        return documentRespons;
    }

    public Specification getSpecification() {
        return specification;
    }

    public Date getQuotaDate() {
        return quotaDate;
    }

    public String getTaxClassification() {
        return taxClassification;
    }

    public Description getDescription() {
        return description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public FundSituation getFundSituation() {
        return fundSituation;
    }

    public String getVolatility12m() {
        return volatility12m;
    }

    public String getFormattedVolatility12m() {
        return MathUtils.formatStringPercent(volatility12m);
    }

    public Profitabilities getProfitabilities() {
        return profitabilities;
    }

    public String getNetPatrimony12M() {
        return netPatrimony12M;
    }

    public FundManager getFundManager() {
        return fundManager;
    }

}
