package com.meituan.duplicateimage.apktool;

import brut.androlib.AndrolibException;
import brut.androlib.ApkDecoder;
import brut.directory.DirectoryException;
import com.meituan.duplicateimage.utils.Utils;
import javafx.collections.transformation.FilteredList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
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
    public static String[] getApkImagesPath(final String apkDir, final String outDir) {
        File apkFile = new File(apkDir);
        File out = new File(outDir);
        if (!apkFile.isFile() || !out.isDirectory()) {
            throw new IllegalArgumentException("待解析的文件必须是一个apk文件，且输出路径必须是一个目录");
        }
        ApkDecoder decoder = new ApkDecoder();
        decoder.setApkFile(apkFile);
        try {
            File decodeDir = new File(outDir + File.separator + Utils.getFilenameWithoutExtension(apkFile));
            if (decodeDir.exists()) {
                FileUtils.deleteDirectory(decodeDir);
            }
            decoder.setOutDir(decodeDir);
            decoder.decode();
            String resFile = out.getAbsolutePath() + File.separator + Utils.getFilenameWithoutExtension(apkFile) + File.separator + "res";
            return listPathes(new File(resFile));
        } catch (AndrolibException | IOException | DirectoryException e) {
            return null;
        }
    }

    private static String[] listPathes(File rootFolder) {
        String[] result = rootFolder.list((dir, name) -> dir.isDirectory() && name.startsWith("drawable") || name.startsWith("mipmap"));
        final String root = rootFolder.getAbsolutePath() + File.separator;
        for (int i = 0; result != null && i < result.length; i++) {
            result[i] = root + result[i];
        }
        return result;
    }
}
