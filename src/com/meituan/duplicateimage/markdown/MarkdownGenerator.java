package com.meituan.duplicateimage.markdown;

import com.meituan.duplicateimage.bean.ImageFile;
import com.meituan.duplicateimage.utils.Utils;
import net.steppschuh.markdowngenerator.image.Image;
import net.steppschuh.markdowngenerator.text.heading.Heading;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 根据比对结果生成markdown文件
 */
public class MarkdownGenerator {

    public static void buildMarkdownFile(List<List<ImageFile>> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("未找到相似图片");
            return;
        }
        System.out.println("找到相似图片：" + results.size() + " 组");
        File file = new File("similar.md");
        BufferedWriter writer = null;
        if (file.exists()) {
            file.delete();
        }

        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < results.size(); i++) {
                writer.write(new Heading("第" + (i + 1) + "组相似图片", 2).toString());
                writer.newLine();
                for (ImageFile imageFile : results.get(i)) {
                    writer.write(new Image(imageFile.name, imageFile.mFile.getAbsolutePath()).toString());
                }
                writer.newLine();
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("相似图片结果报告写入失败");
        } finally {
            Utils.safelyClose(writer);
        }

    }


    public static void buildMarkdownFile(Map<String, List<List<ImageFile>>> results) {
        if (results == null || results.isEmpty()) {
            System.out.println("未找到相似图片");
            return;
        }
        File file = new File("similar.md");
        BufferedWriter writer = null;
        if (file.exists()) {
            file.delete();
        }
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            for (String key : results.keySet()) {
                List<List<ImageFile>> imgs = results.get(key);
                writer.write(new Heading(key, 1).toString());
                writer.newLine();
                for (int i = 0; i < imgs.size(); i++) {
                    writer.write(new Heading("第" + (i + 1) + "组相似图片", 2).toString());
                    writer.newLine();
                    for (ImageFile imageFile : imgs.get(i)) {
                        writer.write(new Image(imageFile.name, imageFile.mFile.getAbsolutePath()).toString());
                    }
                    writer.newLine();
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("相似图片结果报告写入失败");
        } finally {
            Utils.safelyClose(writer);
        }

    }


}
