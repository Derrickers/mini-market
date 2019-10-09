package com.minimarket.utils;

/**
 * @author ronjod
 * @create 2019-10-08 22:57
 */
public class AddressUtil {
    public static String getAddress(String fileName) {
        if(fileName.length()>81)
            return "0x" + fileName.substring(37,77);
        else
        return "0x" + fileName.substring(37);
    }
}
