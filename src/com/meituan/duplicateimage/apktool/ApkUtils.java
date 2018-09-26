package com.meituan.duplicateimage.apktool;

import brut.androlib.AndrolibException;
import brut.androlib.ApkDecoder;
import brut.directory.DirectoryException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * apk解包相关工具
 */
public class ApkUtils {

    /**
     * 解析apk文件，找出里面的图片资源所在路径，并返回出来
     *
     * @param apkDir
     * @param outDir
     * @return
     */
    public static List<String> getApkImagesPath(final String apkDir, final String outDir) {
        File apkFile = new File(apkDir);
        File out = new File(outDir);
        //TODO xiayong 看看能不能在decode的时候不创建新的目录
//        if (!apkFile.isFile() || !out.isDirectory()) {
//            throw new IllegalArgumentException("待解析的文件必须是一个apk文件，且输出路径必须是一个目录");
//        }
        ApkDecoder decoder = new ApkDecoder();
        decoder.setApkFile(apkFile);
        try {
            decoder.setOutDir(out);
            decoder.decode();
            String resFile = outDir + "/" + apkFile.getName() + "/res";
            return null;
        } catch (AndrolibException | IOException | DirectoryException e) {
            return null;
        }
    }
}
