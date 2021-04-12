package com.kg.demo.utils;

public class Lowercase {
    public static String lowerCase(String s){
        int d = 'A' - 'a';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') c -= d;
            sb.append(c);
        }
        return sb.toString();
    }
}
