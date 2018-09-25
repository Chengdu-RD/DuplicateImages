package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.Image;

/**
 * pHash比较
 */
public class pHashComparer implements ImageComparer{
    @Override
    public boolean isSimilar(Image img1, Image img2) {
        return false;
    }
}
