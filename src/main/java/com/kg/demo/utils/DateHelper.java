package com.kg.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");//设置日期格式
        return df.format(new Date());
    }
}
