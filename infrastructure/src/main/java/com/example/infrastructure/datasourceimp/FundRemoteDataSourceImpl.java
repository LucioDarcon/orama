package com.example.infrastructure.datasourceimp;

import android.os.Environment;

import com.example.infrastructure.GuidGenerator;
import com.example.infrastructure.apidatasource.FundApiDataSource;
import com.example.infrastructure.callback.GetPdfCallBack;
import com.example.infrastructure.remotedatasource.FundRemoteDataSource;
import com.example.infrastructure.callback.GetFundListCallBack;
import com.example.infrastructure.response.Fund;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                         "as.pdf");
                try {
                    byte[] fileReader = new byte[4096];
                    long fileSize = response.body().contentLength();
                    long fileSizeDownloaded = 0;

                    InputStream inputStream = response.body().byteStream();
                    OutputStream outputStream = new FileOutputStream(file);

                    while (true) {
                        int read = inputStream.read(fileReader);

                        if (read == -1) {
                            break;
                        }

                        outputStream.write(fileReader, 0, read);

                        fileSizeDownloaded += read;
                    }
                    outputStream.flush();
                    getPdfCallBack.getPdtSuccess(file);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
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
