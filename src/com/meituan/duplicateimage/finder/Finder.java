package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;

import java.util.ArrayList;
import java.util.List;

public class Finder {
    private List<ImageComparer> mImageComparers;
    private List<List<ImageFile>> mResults;

    public Finder() {
        mImageComparers = new ArrayList<>();
        mResults = new ArrayList<>();
    }

    public void addComparers(ImageComparer... imageComparers) {
        for (ImageComparer i : imageComparers) {
            mImageComparers.add(i);
        }
    }

    public void start(List<ImageFile> images) {
        if (images == null || images.size() == 0) {
            return;
        }
        System.out.println("====================开始查找相似图片======================");
        List<ImageFile> files = new ArrayList<>();
        boolean[] checked = new boolean[images.size()];
        for (int i = 0; i < images.size(); i++) {
            if (checked[i]) {
                continue;
            }
            for (int j = i + 1; j < images.size(); j++) {
                System.out.println("正在处理第" + (i + 1) + "个图片和第" + (j + 1) + "个图片...");
                if (isSimilarImage(images.get(i), images.get(j))) {
                    files.add(images.get(j));
                    checked[j] = true;
                }
            }
            if (!files.isEmpty()) {
                files.add(0, images.get(i));
                mResults.add(files);
            }
        }
        System.out.println("====================结束查找相似图片======================");
    }

    private boolean isSimilarImage(ImageFile img1, ImageFile img2) {
        for (ImageComparer imageComparer : mImageComparers) {
            if (!imageComparer.isSimilar(img1, img2)) {
                return false;
            }
        }
        return true;
    }

}
