package com.kg.demo.utils;

import com.alibaba.fastjson.JSONObject;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
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

    // 无法注入@bean
    public static <T> T jsonToObject(JSONObject jsonObject, Class<T> beanClass){
        try{
            Map<String, Object> map = JsonHelper.jsonObjectParser(jsonObject);
            T obj = beanClass.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] pd = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor p : pd){
                System.out.println(p.toString());
                Method setter = p.getWriteMethod();
                if(setter != null){
                    setter.invoke(obj, map.get(p.getName()));
                }
            }
            return obj;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
