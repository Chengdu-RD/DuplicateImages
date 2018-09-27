package com.meituan.duplicateimage;

import com.meituan.duplicateimage.apktool.ApkUtils;
import com.meituan.duplicateimage.bean.ImageFile;
import com.meituan.duplicateimage.markdown.MarkdownGenerator;
import com.meituan.duplicateimage.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        System.out.println("请输入apk文件路径");
//        String apkDir = Utils.readPath();
//        System.out.println("请输入apk解压目录");
//        String outDir = Utils.readPath();
//        List<String> imgPathes = ApkUtils.getApkImagesPath(apkDir,outDir);

//        System.out.println("选择的目录是：" + path);
//        FileScanner fileScanner = new FileScanner(path);
//        List<ImageFile> result = fileScanner.scan();

        List<List<ImageFile>> lists = new ArrayList<>();
        List<ImageFile> list1 = new ArrayList<>();
        List<ImageFile> list2 = new ArrayList<>();

        ImageFile imageFile11 = new ImageFile(new File("/Users/xiayong/Desktop/similarImage/boss_about_icon.png"));
        ImageFile imageFile12 = new ImageFile(new File("/Users/xiayong/Desktop/similarImage/boss_arrow_back.png"));
        ImageFile imageFile21 = new ImageFile(new File("/Users/xiayong/Desktop/similarImage/boss_arrow_down_icon_copy.png"));
        ImageFile imageFile22 = new ImageFile(new File("/Users/xiayong/Desktop/similarImage/boss_tab_message_selected.png"));
        ImageFile imageFile23 = new ImageFile(new File("/Users/xiayong/Desktop/similarImage/boss_printer_label_icon.png"));
        list1.add(imageFile11);
        list1.add(imageFile12);
        list2.add(imageFile21);
        list2.add(imageFile22);
        list2.add(imageFile23);

        lists.add(list1);
        lists.add(list2);
        MarkdownGenerator.buildMarkdownFile(lists);
    }
}
