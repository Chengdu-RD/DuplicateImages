package com.meituan.duplicateimage.bean;

import java.io.File;

/**
 * 一个对象对应一个图片文件
 */
public class ImageFile {
    public String name;
    public File mFile;
    public String mHash;//pHash算法生成的hash值
    public float[] mHistogramData;// TODO xiayong 比较耗内存，是否有优化空间 采用分治之类？
    public int mHeight = -1;
    public int mWidth = -1;

    public ImageFile(final File file) {
        mFile = file;
        if (!mFile.exists()) {
            throw new IllegalArgumentException("input file does not exist,please check the path");
        }
        name = mFile.getName();
    }
}
