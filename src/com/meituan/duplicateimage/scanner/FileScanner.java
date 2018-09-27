package com.meituan.duplicateimage.scanner;

import com.meituan.duplicateimage.bean.ImageFile;

import java.io.File;
import java.util.*;

public class FileScanner {

    private String[] mSuffix = new String[]{".png", ".jpg"};
    public String mPath;

    private List<ImageFile> mImages;

    public FileScanner(String path) {
        mPath = path;
        mImages = new ArrayList<>();
    }

    public List<ImageFile> scan() {
        System.out.println("正在扫描当前文件夹...");
        scan(mPath);
        System.out.print("\r");
        System.out.println("扫描完成，共发现" + mImages.size() + "个图片文件");
        return mImages;
    }

    private void scan(String path) {
        File root = new File(path);
        if (root.exists()) {
            System.out.print("\r");
            System.out.print(path);
            if (root.isDirectory()) {
                File[] files = root.listFiles();
                for (int i = 0; files != null && i < files.length; i++) {
                    scan(files[i].getPath());
                }
            } else {
                for (int i = 0; i < mSuffix.length; i++) {
                    if (root.getName().endsWith(mSuffix[i])) {
                        ImageFile file = new ImageFile(root);
                        mImages.add(file);
                    }
                }
            }
        }
    }

}
