package org.company.name.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class MD5 {
    public static String md5(String pass) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] data = MessageDigest.getInstance("MD5").digest(pass.getBytes("UTF-8"));
            for (byte adata : data) {
                sb.append(Integer.toHexString((adata & 0XFF) | 0X100).substring(1, 3));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
