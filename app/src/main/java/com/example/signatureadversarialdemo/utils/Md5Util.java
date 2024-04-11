package com.example.signatureadversarialdemo.utils;

import java.security.MessageDigest;

/**
 * 创建日期：2024-04-11
 * 作者:baiyang
 */
public class Md5Util {
    /**
     * 计算MD5值
     */
    public static String MD5(String data) {
        try {
            String str = MD5(data.getBytes());
            return str;
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * 计算MD5值
     */
    public static String MD5(byte[] data) {
        try {
            // 获取data的MD5摘要
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // mdInst.update(content.getBytes());
            mdInst.update(data);
            byte[] md = mdInst.digest();

            // 转换为十六进制的字符串形式
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                String shaHex = Integer.toHexString(md[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
