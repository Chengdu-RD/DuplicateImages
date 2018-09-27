package com.meituan.duplicateimage.utils;

import org.apache.commons.io.FilenameUtils;

import java.io.*;

public class Utils {

    public static String readPath() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bf.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    public static void safelyClose(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFilenameWithoutExtension(File file){
        int l = FilenameUtils.indexOfExtension(file.getName());
        return l == -1 ? "" : file.getName().substring(0,l);
    }
}
