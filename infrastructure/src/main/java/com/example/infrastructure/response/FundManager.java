package com.example.infrastructure.response;

import com.google.gson.annotations.SerializedName;

public class FundManager {

    @SerializedName("id")
    private Integer id;

    @SerializedName("description")
    private String description;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("logo")
    private String logo;

    @SerializedName("slug")
    private String slug;

    @SerializedName("name")
    private String name;

    public FundManager(String description, String name, String fullName) {
        this.description = description;
        this.name = name;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogo() {
        return logo;
    }

    public String getSlug() {
        return slug;
    }

    public String getName() {
        return name;
    }

}
