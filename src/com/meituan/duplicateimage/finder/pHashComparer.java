package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;
import com.meituan.duplicateimage.utils.HashCodeUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * pHash比较
 */
public class pHashComparer implements ImageComparer {
    @Override
    public boolean isSimilar(ImageFile img1, ImageFile img2) {
        if (StringUtils.isEmpty(img1.mHash)) {
            img1.mHash = HashCodeUtils.getInstance().getHash(img1.mFile);
        }
        if (StringUtils.isEmpty(img2.mHash)) {
            img2.mHash = HashCodeUtils.getInstance().getHash(img2.mFile);
        }
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
