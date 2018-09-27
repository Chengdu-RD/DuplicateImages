package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;
import com.meituan.duplicateimage.utils.Utils;

/**
 * 图片大小比较
 */
public class SizeComparer implements ImageComparer {
    @Override
    public boolean isSimilar(ImageFile img1, ImageFile img2) {
        if (img1.mHeight == -1 || img1.mWidth == -1) {
            int[] size = Utils.getImageFileSize(img1.mFile);
            img1.mWidth = size[0];
            img1.mHeight = size[1];
        }

        if (img2.mHeight == -1 || img2.mWidth == -1) {
            int[] size = Utils.getImageFileSize(img2.mFile);
            img2.mWidth = size[0];
            img2.mHeight = size[1];
        }
        return img1.mHeight == img2.mHeight && img1.mWidth == img2.mWidth;
    }
}
