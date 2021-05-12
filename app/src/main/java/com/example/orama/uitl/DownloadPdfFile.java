package com.example.orama.uitl;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;

import androidx.annotation.NonNull;

import java.io.File;

public class DownloadPdfFile extends AsyncTask<String, Void, Void> {

    Context mContext;

    @Override
    protected Void doInBackground(String... strings) {
        String fileUrl  = strings[0];
        String fileName = strings[1];

        String externalStorage = Environment.getExternalStorageState().toString();

        File folder = new File(externalStorage, "PDF DOWNLOAD");
        folder.mkdir();

        File pdfFile = new File(folder, fileName);

        try {
            pdfFile.createNewFile();
        }catch (Exception e) {
            e.printStackTrace();
        }

        FileDownloader.downloadFile(fileUrl, pdfFile);

        return null;
    }
}
