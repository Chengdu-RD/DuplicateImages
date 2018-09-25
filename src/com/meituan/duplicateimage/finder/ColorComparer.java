package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.Image;

/**
 * 颜色比较
 */
public class ColorComparer implements ImageComparer{
    @Override
    public boolean isSimilar(Image img1, Image img2) {
        return false;
    }
}
