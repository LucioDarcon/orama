package com.example.orama.uitl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FileDownloader {

    private static final int MEGABYTE = 1024*1024;

    public static void downloadFile(String fileUrl, File directory) {
        try{
            URL url = new URL(fileUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(directory);

            int totalSize = urlConnection.getContentLength();
            byte [] buffer = new byte[MEGABYTE];
            int bufferLenght = 0;

            while ((bufferLenght = inputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, bufferLenght);
            }
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
