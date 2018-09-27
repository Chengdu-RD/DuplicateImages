package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;

/**
 * pHash比较
 */
public class pHashComparer implements ImageComparer{
    @Override
    public boolean isSimilar(ImageFile img1, ImageFile img2) {
        return false;
    }
}
