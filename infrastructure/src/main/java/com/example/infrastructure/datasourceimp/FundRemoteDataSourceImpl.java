package com.example.infrastructure.datasourceimp;

import com.example.infrastructure.apidatasource.FundApiDataSource;
import com.example.infrastructure.callback.GetPdfCallBack;
import com.example.infrastructure.remotedatasource.FundRemoteDataSource;
import com.example.infrastructure.callback.GetFundListCallBack;
import com.example.infrastructure.response.Fund;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.infrastructure.uitl.FileDownloader.downloadFile;


public class FundRemoteDataSourceImpl implements FundRemoteDataSource {

    private static FundRemoteDataSourceImpl INSTANCE;
    private final FundApiDataSource fundApiDataSource;

    private FundRemoteDataSourceImpl(FundApiDataSource apiDataSource) {
        fundApiDataSource = apiDataSource;
    }

    public static FundRemoteDataSourceImpl getInstance(FundApiDataSource fundApiDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new FundRemoteDataSourceImpl(fundApiDataSource);
        }

        return INSTANCE;
    }

    @Override
    public void getPDF(GetPdfCallBack getPdfCallBack, String url) {
        Call<ResponseBody> pdfCallback = fundApiDataSource.downloadFile(url);

        pdfCallback.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                downloadFile(response, getPdfCallBack);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {}
        });

    }

    @Override
    public void getFundApiList(GetFundListCallBack getFundListCallBack) {
        Call<List<Fund>> fundListApiCall = fundApiDataSource.getFundApiResponse();

        fundListApiCall.enqueue(new Callback<List<Fund>>() {
            @Override
            public void onResponse(Call<List<Fund>> call, Response<List<Fund>> response) {
                List<Fund> fundList = response.body();
                getFundListCallBack.getFundListSuccess(fundList);
            }

            @Override
            public void onFailure(Call<List<Fund>> call, Throwable throwable) {
                getFundListCallBack.getFundListFailure(throwable);
            }
        });
    }

}
