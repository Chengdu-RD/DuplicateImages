package com.meituan.duplicateimage;

import com.meituan.duplicateimage.apktool.ApkUtils;
import com.meituan.duplicateimage.bean.ImageFile;
import com.meituan.duplicateimage.finder.ColorComparer;
import com.meituan.duplicateimage.finder.Finder;
import com.meituan.duplicateimage.finder.SizeComparer;
import com.meituan.duplicateimage.finder.pHashComparer;
import com.meituan.duplicateimage.markdown.MarkdownGenerator;
import com.meituan.duplicateimage.scanner.FileScanner;
import com.meituan.duplicateimage.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入apk文件路径");
        String apkDir = Utils.readPath();
        System.out.println("请输入apk解压目录");
        String outDir = Utils.readPath();
//        String[] imgPaths = ApkUtils.getApkImagesPath("/Users/xiayong/Desktop/test/a.apk", "/Users/xiayong/Desktop/test");
        String[] imgPaths = ApkUtils.getApkImagesPath(apkDir, outDir);
//        String[] imgPaths = {"/Users/xiayong/Desktop/test/a/res/drawable-mdpi-v4"};
        if (imgPaths != null) {
            Finder finder = new Finder();
            finder.addComparers(new SizeComparer(),new pHashComparer(),new ColorComparer());

            Map<String, List<List<ImageFile>>> allSimilarImgs = new HashMap<>();
            for (String path : imgPaths) {
                FileScanner fileScanner = new FileScanner(path);
                List<ImageFile> result = fileScanner.scan();
                List<List<ImageFile>> similarSet = finder.start(result);
                if (!Utils.isCollectionEmpty(similarSet)) {
                    allSimilarImgs.put(path, similarSet);
                }
            }

            MarkdownGenerator.buildMarkdownFile(allSimilarImgs);
        }

    }
}
