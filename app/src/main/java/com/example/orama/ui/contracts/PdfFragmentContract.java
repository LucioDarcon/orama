package com.example.orama.ui.contracts;

import com.example.infrastructure.response.Fund;
import com.example.orama.ui.presenter.MainFragmentPresenter;
import com.example.orama.ui.presenter.PdfPresenter;

import java.io.File;
import java.util.List;

public interface PdfFragmentContract {

    interface View {
        void setPresenter(PdfPresenter pdfPresenter);
        void showFile(File file);
        void errorToGetFundList();
    }


    interface Presenter {
        void getFund(String url);
    }

}

