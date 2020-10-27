package com.kx.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2019/11/7 9:34 上午
 */
public class DateFormatUtil {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(String date) throws Exception {
        Date time = new Date(date.replace("cst", "").replace("CST", ""));
        String timeFormat = format.format(time);
        return timeFormat;
    }

    public static Long toTimeLong(String date) throws Exception {
        Date s =  format.parse(date.replace("cst", "").replace("CST", ""));
        return s.getTime();
    }

    public static Long toTimeLong(Date date) throws Exception {
        return date.getTime();
    }

    public static String toDateString(Date date){
        return DateFormatUtil.format.format(date);
    }

}
