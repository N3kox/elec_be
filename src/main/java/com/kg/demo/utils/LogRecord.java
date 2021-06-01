package com.kg.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class LogRecord {
    /**
     * 加入log
     * @param id node id
     * @param data log map
     * @return log写入是否成功
     */
    public static boolean appendLog(Long id, Map<String, Object> data){
        JSONArray array = JsonHelper.readLogFile(id.toString());
        if(array == null) return false;
        String currentTime = DateHelper.getCurrentTime();
        for(String k : data.keySet()){
            JSONObject jo = new JSONObject();
            jo.put("update_time_stamp", currentTime);
            jo.put(k, data.get(k));
            array.add(jo);
        }
        return JsonHelper.writeLogFile(id.toString(), array.toJSONString());
    }

    /**
     * 读取log
     * @param id node log
     * @return log内容
     */
    public static String readLog(Long id){
        JSONArray ja = JsonHelper.readLogFile(id.toString());
        if(ja != null) return ja.toJSONString();
        return null;
    }
}
