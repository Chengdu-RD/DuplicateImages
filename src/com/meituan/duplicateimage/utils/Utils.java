package com.meituan.duplicateimage.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    public static String readPath() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bf.readLine();
        } catch (IOException e) {
            return "";
        }
    }
}
