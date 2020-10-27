package com.kx.demo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/8/8 4:58 下午
 */

public class HashCalculateUtil {


    /**
     * 计算hash 值
     */

    public static String getFileSha1(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            digest.update(data);
            String sha1 = new BigInteger(1, digest.digest()).toString(16);
            int length = 40 - sha1.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    sha1 = "0" + sha1;
                }
            }
            return sha1;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getFileMD5(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(data);
            String md5 = new BigInteger(1, digest.digest()).toString(16);
            int length = 32 - md5.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    md5 = "0" + md5;
                }
            }
            return md5;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    private static int flag = 0;
    private static int i = 0;  //改为Integer 就没事儿了

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                flag = 1;
                System.out.println(flag + " 一");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(flag + " 二");

        while (flag == 0) {
            i++;
        }
        System.out.println(i + " 三");

    }

}

