package com.example.infrastructure.remotedatasource;

import com.example.infrastructure.callback.GetFundListCallBack;
import com.example.infrastructure.callback.GetPdfCallBack;

public interface FundRemoteDataSource {

    void getFundApiList(GetFundListCallBack getFundListCallBack);

    void getPDF(GetPdfCallBack getPdfCallBack, String url);

}
