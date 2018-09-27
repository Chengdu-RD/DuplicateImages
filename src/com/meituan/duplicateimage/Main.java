package com.meituan.duplicateimage;

import com.meituan.duplicateimage.apktool.ApkUtils;
import com.meituan.duplicateimage.utils.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入apk文件路径");
        String apkDir = Utils.readPath();
        System.out.println("请输入apk解压目录");
        String outDir = Utils.readPath();
        List<String> imgPathes = ApkUtils.getApkImagesPath(apkDir,outDir);

//        System.out.println("选择的目录是：" + path);
//        FileScanner fileScanner = new FileScanner(path);
//        List<ImageFile> result = fileScanner.scan();

    }
}
