package com.kx.demo.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/12/3 10:26 上午
 */
public class InputStreamToStringUtil {

    private static final String REGEX_CHINESE = "[\u4e00-\u9fa5]";// 中文正则

    private static Pattern pat = Pattern.compile(REGEX_CHINESE);

    public static String readStringByinputStream(InputStream inputStream) throws IOException {

        Reader reader = new InputStreamReader(inputStream, "utf-8");
        StringBuffer sb = new StringBuffer();
        int ch = 0;
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        reader.close();
        return sb.toString();
    }

    /**
     * 去掉汉字
     *
     * @param target
     * @return
     */
    public static String takeString(String target) {
        Matcher mat = pat.matcher(target);
        return mat.replaceAll("");
    }
}
