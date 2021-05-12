package com.example.infrastructure.uitl;

import android.os.Environment;

import com.example.infrastructure.callback.GetPdfCallBack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class FileDownloader {

    public static void downloadFile(Response<ResponseBody> response, GetPdfCallBack getPdfCallBack) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                GuidGenerator.generator() + ".pdf");
        try {
            byte[] fileReader       = new byte[4096];
            long fileSize           = response.body().contentLength();
            long fileSizeDownloaded = 0;
            InputStream inputStream = response.body().byteStream();

            OutputStream outputStream = new FileOutputStream(file);
            while (true) {
                int read = inputStream.read(fileReader);
                if (read == -1) {
                    break;
                }
                outputStream.write(fileReader, 0, read);
                fileSizeDownloaded += read;
            }
            outputStream.flush();
            getPdfCallBack.getPdtSuccess(file);
        } catch (Exception e) {
            getPdfCallBack.getPdfFailure(e);
        }
    }

}
