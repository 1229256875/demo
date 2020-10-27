package com.kx.demo.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/9/1 5:03 下午
 */

public class FileUtil {


    /**
     * 获取这个路径下 所有指定后缀的文件集合
     *
     * @param path       指定路径
     * @param fileSuffix 指定后缀
     * @return 文件集合
     */
    public static List<File> scan(String path, String fileSuffix) {
        List<File> fileList = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            return fileList;
        }

        scan(file, fileSuffix, fileList);

        return fileList;
    }

    /**
     * 递归调用
     *
     * @param file
     * @param fileSuffix
     * @param fileList
     */
    public static void scan(File file, String fileSuffix, List<File> fileList) {

        if (file.isDirectory()) {
            Arrays.stream(file.listFiles()).filter(Objects::nonNull).forEach(var -> scan(var, fileSuffix, fileList));
        } else if (file.getName().endsWith(fileSuffix)) {
            fileList.add(file);
        }
    }

    //将文件转换成Byte数组
    public static byte[] getBytesByFile(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean createFileDir(String dir) {
        File file = new File(dir);

        if (file.exists())
            return true;

        return file.mkdirs();
    }

    public static String randomString() {
        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < 24; i++) {
            int i1 = random.nextInt(57) + 65;
            if (i1 == 92)
                i1++;
            sb.append((char) i1);
        }
        return sb.toString();
    }


}
