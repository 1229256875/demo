package com.kx.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/7/1 3:21 下午
 */
@Slf4j
public class DateUtil {

    private static SimpleDateFormat var0 = new SimpleDateFormat("yyyy-MM-dd");

    private static SimpleDateFormat var00 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Map<String, String> stringStringMap = new HashMap<>();

    static {
        stringStringMap.put("Mar", "03");
        stringStringMap.put("Jan", "01");
        stringStringMap.put("Feb", "02");
        stringStringMap.put("Apr", "04");
        stringStringMap.put("May", "05");
        stringStringMap.put("Jun", "06");
        stringStringMap.put("Jul", "07");
        stringStringMap.put("Aug", "08");
        stringStringMap.put("Sep", "09");
        stringStringMap.put("Oct", "10");
        stringStringMap.put("Nov", "11");
        stringStringMap.put("Dec", "12");
    }

    public static String getDate(String str) {
        return stringStringMap.getOrDefault(str, "");
    }

    public static Long dateConversionLong(String date) {
        return dateConversionLong(date, var0);
    }

    public static Long dateConversionLong(String date, SimpleDateFormat simpleDateFormat) {
        try {
            Date parse = simpleDateFormat.parse(date);
            return parse.getTime();
        } catch (Exception e) {
            log.error("时间转化时间戳异常: {}", e.getMessage(), e);
            return 0L;
        }
    }

    public static String stringConversionDate(String date) {
        return stringConversionDate(date, var0);
    }

    public static String stringConversionDate(String date, SimpleDateFormat simpleDateFormat) {
        try {
            Date parse = simpleDateFormat.parse(date);
            return simpleDateFormat.format(parse);
        } catch (Exception e) {
            log.error("时间转化时间戳异常: {}", e.getMessage(), e);
            return "";
        }
    }

    public static String longConversionDate(Long time) {
        return longConversionDate(time, var0);
    }

    public static String longConversionDate(Long time, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.format(time);
        } catch (Exception e) {
            log.error("时间戳转化时间异常: {}", e.getMessage(), e);
            return "";
        }
    }


    public static SimpleDateFormat getVar0() {
        return var0;
    }

    public static SimpleDateFormat getVar00() {
        return var00;
    }
}
