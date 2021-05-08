package com.example.core.service;

import com.example.orama.model.Fund;

import java.util.List;

public interface GetFundListCallBack {

    void getFundListSuccess(List<Fund> fundList);

    void getFundListFailure(Throwable throwable);

}
