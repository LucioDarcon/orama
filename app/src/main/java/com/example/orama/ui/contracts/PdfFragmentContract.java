package com.example.orama.ui.contracts;

import com.example.infrastructure.response.Fund;
import com.example.orama.ui.presenter.MainFragmentPresenter;
import com.example.orama.ui.presenter.PdfPresenter;

import java.io.File;
import java.util.List;

public interface PdfFragmentContract {

    interface View {
        void setPresenter(PdfPresenter pdfPresenter);
        void loadFile(File file);
        void error();
        void loadProgressBar();
        void setVisiblePdfFile();
    }


    interface Presenter {
        void getPdfDocument(String url);
    }

}

