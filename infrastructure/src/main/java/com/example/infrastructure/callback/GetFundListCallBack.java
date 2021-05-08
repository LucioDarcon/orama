package com.example.infrastructure.callback;

import com.example.infrastructure.response.Fund;

import java.util.List;

public interface GetFundListCallBack {

    void getFundListSuccess(List<Fund> fundList);

    void getFundListFailure(Throwable throwable);

}
