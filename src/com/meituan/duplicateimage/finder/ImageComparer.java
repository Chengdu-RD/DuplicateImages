package com.meituan.duplicateimage.finder;

import com.meituan.duplicateimage.bean.Image;

public interface ImageComparer {

    boolean isSimilar(Image img1,Image img2);
}
