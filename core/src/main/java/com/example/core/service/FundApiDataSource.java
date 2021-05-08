package com.example.core.service;

import com.example.orama.model.Fund;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FundApiDataSource {

    @GET("json/fund_detail_full.json?serializer=fund_detail_full")
    Call<List<Fund>> getFundApiResponse();

}
