package com.example.orama.ui;

public interface MainFragmentContract {

    interface View {
        void setPresenter(MainFragmentPresenter mainFragmentPresenter);
    }


    interface Presenter {
        void getFund();
    }

}
