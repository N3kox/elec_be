package com.kg.demo.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonHelper {
    public static Map<String, Object> jsonObjectParser(JSONObject jsonObject){
        Map<String, Object> map = new HashMap<String, Object>();
        for(Map.Entry<String, Object> entry : jsonObject.entrySet()){
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
}
