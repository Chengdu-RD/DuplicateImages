package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;

/**
 * 颜色比较
 */
public class ColorComparer implements ImageComparer{
    @Override
    public boolean isSimilar(ImageFile img1, ImageFile img2) {
        return false;
    }
}
