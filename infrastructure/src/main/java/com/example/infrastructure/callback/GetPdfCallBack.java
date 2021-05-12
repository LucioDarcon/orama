package com.example.infrastructure.callback;


import java.io.File;

public interface GetPdfCallBack {

    void getPdtSuccess(File file);

    void getPdfFailure(Throwable throwable);

}
