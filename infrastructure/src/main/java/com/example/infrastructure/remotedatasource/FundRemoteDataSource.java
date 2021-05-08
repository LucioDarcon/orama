package com.example.infrastructure.remotedatasource;

import com.example.infrastructure.callback.GetFundListCallBack;

public interface FundRemoteDataSource {

    void getFundApiList(GetFundListCallBack getFundListCallBack);

}
