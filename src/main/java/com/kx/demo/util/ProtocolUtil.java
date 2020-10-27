package com.kx.demo.util;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.arraycopy;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/2/26 9:12 上午
 */
public class ProtocolUtil {


    public static byte[] int2Bytes(int myInteger) {
        return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(myInteger).array();
    }

    public static int bytes2Int(byte[] byteBarray) {
        return ByteBuffer.wrap(byteBarray).order(ByteOrder.BIG_ENDIAN).getInt();
    }


    //拆解数据,前32位为数据长度
    //datas[0] 表示拆解出来的数据
    //datas[1] 表示剩下未拆解的数据
    public static byte[][] calculateToData(byte[] bytes) {
        if (bytes.length <= 4) return null;
        byte[][] datas = new byte[2][];
        //长度
        int len = bytes2Int(Arrays.copyOfRange(bytes, 0, 4));
        //数据
        datas[0] = Arrays.copyOfRange(bytes, 4, len + 4);
        if ((len + 4) > bytes.length)
            return null;
        datas[1] = Arrays.copyOfRange(bytes, 4 + len, bytes.length);
        return datas;
    }

    public static List<byte[]> disassemble(byte[] bytes) {
        List<byte[]> list = new ArrayList<>();
        byte[][] bytes1;
        do {
            bytes1 = calculateToData(bytes);
            if (bytes1 == null) break;
            list.add(bytes1[0]);
            if (bytes1[1].length == 0) break;
            bytes = bytes1[1];
        } while (true);
        return list;
    }


    /**
     * 组合数据  前32位  为数据长度
     *
     * @param bytes   新数据
     * @param oldData 原始数据
     * @return
     */
    public static byte[] calculateToBytes(byte[] bytes, byte[] oldData) {
        int len = bytes.length;
        if (len <= 0) return null;
        byte[] bytes1 = int2Bytes(len);
        byte[] od = new byte[4 + bytes.length + oldData.length];
        arraycopy(bytes1, 0, od, 0, 4);
        arraycopy(bytes, 0, od, 4, len);
        arraycopy(oldData, 0, od, 4 + len, oldData.length);
        return od;
    }


    public static byte[] allToBytes(byte[] bytes, byte[] oldData) {
        int len = bytes.length;

        int oldLen = oldData.length;
        //创建一个新的byte数组
        byte[] od = new byte[bytes.length + oldLen];

        arraycopy(bytes, 0, od, 0, len);
        arraycopy(oldData, 0, od, len, oldLen);
        return od;
    }


}
