package com.example.core.provider;

import com.example.core.BuildConfig;
import com.example.infrastructure.apidatasource.FundApiDataSource;

public class ProvideApiDataSource {

    private static ApiDataSource provideApiDataSource() {
        return ApiDataSource.getInstance(BuildConfig.BASE_URL);
    }

    public static FundApiDataSource provideFundApiDataSource() {
        return provideApiDataSource().fundApiDataSource();
    }


}
