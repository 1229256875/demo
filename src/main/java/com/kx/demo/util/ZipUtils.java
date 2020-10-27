package com.kx.demo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @Auther: ybdo
 * @Date: 2019/12/17 17:59
 * @Description:
 */
public class ZipUtils {


    public static byte[] uncompress(byte[] bytes) throws IOException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        GZIPInputStream ungzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = ungzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }

        return out.toByteArray();
    }

    public static byte[] compress(final byte[] str) throws IOException {
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);
        gzip.write(str);
        gzip.flush();
        gzip.close();
        return obj.toByteArray();
    }

    public static byte[] decompress(final byte[] compressed) throws IOException {
        if (isCompressed(compressed)) {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
            try {
                byte[] bytes = new byte[200];
                int line;
                while ((line = gis.read(bytes)) != -1) {
                    byteArrayOutputStream.write(bytes, 0, line);
                }
            } finally {
                gis.close();
            }
            return byteArrayOutputStream.toByteArray();
        } else {
            return compressed;
        }
    }

    public static boolean isCompressed(final byte[] compressed) {
        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
    }
}
