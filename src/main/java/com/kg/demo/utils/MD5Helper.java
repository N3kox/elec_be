package com.kg.demo.utils;

import org.springframework.util.DigestUtils;

public class MD5Helper {
    public static String strToMd5(String text){
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }
}
