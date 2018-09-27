package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.ImageFile;

public interface ImageComparer {

    boolean isSimilar(ImageFile img1, ImageFile img2);
}
