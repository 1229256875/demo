package com.kx.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/6/27 2:46 上午
 */
@Slf4j
public class CloseUtil {

    /**
     * 关闭 各种流
     */

    public static void closeInputStream(InputStream inputStream) {
        if (inputStream == null) return;
        try {
            inputStream.close();
        } catch (IOException e) {
            log.error("关闭流异常{}", e.getLocalizedMessage());
        }
    }


    public static void closeFileWriter(FileWriter fileWriter) {
        if (fileWriter == null) return;
        try {
            fileWriter.close();
        } catch (IOException e) {
            log.error("关闭流异常{}", e.getLocalizedMessage());
        }
    }


    public static void closeRandomAccessFile(RandomAccessFile randomAccessFile) {
        if (randomAccessFile == null) return;
        try {
            randomAccessFile.close();
        } catch (IOException e) {
            log.error("关闭流异常{}", e.getLocalizedMessage());
        }
    }

    public static void closeByteArrayOutputStream(OutputStream outputStream) {
        if (outputStream == null) return;
        try {
            outputStream.close();
        } catch (IOException e) {
            log.error("关闭流异常{}", e.getLocalizedMessage());
        }
    }

}
