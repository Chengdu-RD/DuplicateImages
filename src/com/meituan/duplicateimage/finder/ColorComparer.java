package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;
import com.meituan.duplicateimage.utils.ImageHistogramUtil;

/**
 * 颜色比较
 */
public class ColorComparer implements ImageComparer {
    private static final double THRESHOLD = 0.85;
    @Override
    public boolean isSimilar(ImageFile img1, ImageFile img2) {
        if (img1.mHistogramData == null) {
            img1.mHistogramData = ImageHistogramUtil.filter(img1.mFile);
        }
        if (img2.mHistogramData == null) {
            img2.mHistogramData = ImageHistogramUtil.filter(img2.mFile);
        }
        if (img1.mHistogramData == null || img2.mHistogramData == null) {
            return false;
        }
        double value = ImageHistogramUtil.calcSimilarity(img1.mHistogramData,img2.mHistogramData);
        return Double.compare(value,THRESHOLD) > 0;
    }
}
