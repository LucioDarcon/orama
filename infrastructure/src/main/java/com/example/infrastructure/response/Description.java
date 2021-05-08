package com.example.infrastructure.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Description {

    @SerializedName("objective")
    private String objective;

    @SerializedName("movie_url")
    private String movieUrl;

    @SerializedName("target_audience")
    private String targetAudience;

    @SerializedName("strengths")
    private String strengths;

    @SerializedName("strategy")
    private String strategy;

    public Description(String objective) {
        this.objective = objective;
    }

    public String getObjective() {
        return objective;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public String getStrengths() {
        return strengths;
    }

    public String getStrategy() {
        return strategy;
    }

}
