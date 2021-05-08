package com.example.orama.ui.contracts;

import com.example.infrastructure.response.Fund;
import com.example.orama.ui.presenter.MainFragmentPresenter;

import java.util.List;

public interface MainFragmentContract {

    interface View {
        void setPresenter(MainFragmentPresenter mainFragmentPresenter);
        void showFundList(List<Fund> fundList);
        void errorToGetFundList();
    }


    interface Presenter {
        void getFund();
    }

}
