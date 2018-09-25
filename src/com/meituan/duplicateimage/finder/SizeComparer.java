package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.Image;

/**
 * 图片大小比较
 */
public class SizeComparer implements ImageComparer{
    @Override
    public boolean isSimilar(Image img1, Image img2) {
        return img1.mHeight == img2.mHeight && img1.mWidth == img2.mWidth;
    }
}
