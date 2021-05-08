package com.example.core.provider;

import com.example.infrastructure.apidatasource.FundApiDataSource;
import com.example.infrastructure.datasourceimp.FundRemoteDataSourceImpl;
import com.example.infrastructure.remotedatasource.FundRemoteDataSource;

import static com.example.core.provider.ProvideApiDataSource.provideFundApiDataSource;

public class ProvideRemoteDataSource {

    public static FundRemoteDataSource provideFundRemoteDataSource() {
        final FundApiDataSource fundApiDataSource = provideFundApiDataSource();

        return FundRemoteDataSourceImpl.getInstance(fundApiDataSource);
    }

}
