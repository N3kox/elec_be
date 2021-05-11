package com.kg.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kg.demo.config.Static;
import org.springframework.util.ResourceUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JsonHelper {
    // parse JSONObject to map
    public static Map<String, Object> jsonObjectParser(JSONObject jsonObject){
        Map<String, Object> map = new HashMap<>();
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
            e.printStackTrace();
            return null;
        }
    }

    // json文件读取外部接口
    public static String readJsonFile(String fileName){
        File file = null;
        try{
            file = ResourceUtils.getFile(Static.termJsonLocation + fileName + ".json");
//            FileInputStream fin = new FileInputStream(file);
            String res = jsonFileReader(file);
            JSONObject jsonObject = JSONObject.parseObject(res);
            return jsonObject.toJSONString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 读取JSON文件
    private static String jsonFileReader(File file){
        Scanner sc = null;
        StringBuilder sb = new StringBuilder();
        try {
            sc = new Scanner(file, "utf-8");
            while(sc.hasNext())
                sb.append(sc.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(sc != null)
                sc.close();
        }
        return sb.toString();
    }

    // 获取搜索properties map
    public static Map<String, String> getPropertiesKVMap(JSONArray data){
        Map<String, String> m = new HashMap<>();
        for(int i = 0; i < data.size(); i++){
            JSONObject jo = data.getJSONObject(i);
            m.put(jo.get("key").toString(), jo.get("val").toString());
        }
        return m;
    }

}
