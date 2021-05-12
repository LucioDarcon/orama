package com.example.infrastructure.apidatasource;

import com.example.infrastructure.response.Fund;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface FundApiDataSource {

    @GET("json/fund_detail_full.json?serializer=fund_detail_full")
    Call<List<Fund>> getFundApiResponse();

    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String fileUrl);

}
