package com.meituan.duplicateimage;

import com.meituan.duplicateimage.bean.Image;
import com.meituan.duplicateimage.scanner.FileScanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO xiayong 解压apk文件，遍历apk中的路径
        System.out.println("请输入需要处理的路径，不输入回车默认为当前目录：");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String path;
        try {
            str = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (str.length() == 0) {
            File current = new File("");
            path = current.getAbsolutePath();
        } else {
            path = str;
        }

        System.out.println("选择的目录是：" + path);
        FileScanner fileScanner = new FileScanner(path);
        List<Image> result = fileScanner.scan();

    }
}
