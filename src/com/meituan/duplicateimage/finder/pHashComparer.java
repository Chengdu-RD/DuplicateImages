package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;

/**
 * pHash比较
 */
public class pHashComparer implements ImageComparer {
    @Override
    public boolean isSimilar(ImageFile img1, ImageFile img2) {
        return distanceChk(img1.mHash, img2.mHash, 0);
    }

    private boolean distanceChk(String hash1, String hash2, int tv) {
        int counter = 0;
        for (int k = 0; k < hash1.length() && k < hash2.length(); k++) {
            if (hash1.charAt(k) != hash2.charAt(k)) {
                counter++;
            }
        }
        return counter <= tv;
    }
}
