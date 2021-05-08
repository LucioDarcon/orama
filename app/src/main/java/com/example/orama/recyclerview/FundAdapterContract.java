package com.example.orama.recyclerview;

import com.example.infrastructure.response.Fund;

public interface FundAdapterContract {

    interface View {
        void onClickFund(Fund fund);
    }


}
