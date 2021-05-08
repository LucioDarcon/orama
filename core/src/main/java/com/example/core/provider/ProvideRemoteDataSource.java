package com.example.core.provider;

import com.example.core.service.FundApiDataSource;
import com.example.core.service.FundRemoteDataSource;
import com.example.core.service.FundRemoteDataSourceImpl;

import static com.example.core.provider.ProvideApiDataSource.provideFundApiDataSource;

public class ProvideRemoteDataSource {

    public static FundRemoteDataSource provideFundRemoteDataSource() {
        final FundApiDataSource fundApiDataSource = provideFundApiDataSource();

        return FundRemoteDataSourceImpl.getInstance(fundApiDataSource);
    }

}
