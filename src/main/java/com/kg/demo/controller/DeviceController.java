package com.kg.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kg.demo.bean.DeviceEntity;
import com.kg.demo.impl.DeviceImpl;
import com.kg.demo.utils.JsonHelper;
import com.kg.demo.utils.LogRecord;
import org.springframework.web.bind.annotation.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/device")
public class DeviceController extends DeviceImpl {

    @GetMapping("/all")
    @ResponseBody
    List<DeviceEntity> getAllDevices(){
        return selectTop();
    }

    @GetMapping("get")
    @ResponseBody
    DeviceEntity getDeviceById(@RequestParam("id") Long gid){
        return selectDeviceById(gid);
    }


    // 获取device bean全部properties
    @GetMapping("get_properties")
    @ResponseBody
    List<String> getDeviceProperties(){
        List<String> res = new ArrayList<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(DeviceEntity.class);
            PropertyDescriptor[] pd = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor p : pd){
//                System.out.println(p.getPropertyType().toString());
                if(p.getPropertyType().toString().equals("class java.lang.String")){
//                    System.out.println(p.getPropertyType());
                    res.add(p.getName());
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return res;
    }

    @PutMapping("update")
    @ResponseBody
    public boolean updateDevice(@RequestBody JSONObject data, @RequestParam("id") Long id) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        DeviceEntity device = selectDeviceById(id);
        if(device == null) return false;
        Map<String, Object> map = JsonHelper.jsonObjectParser(data);
        Map<String, Object> updateLog = new HashMap<>();
        PropertyDescriptor[] pd = Introspector.getBeanInfo(device.getClass()).getPropertyDescriptors();
        for(PropertyDescriptor p : pd){
            String name = p.getName();
            if(!name.equals("gid") && map.containsKey(name)){
                Method setter = p.getWriteMethod();
                Method getter = p.getReadMethod();
                if(getter != null && !map.get(name).equals(getter.invoke(device).toString())){
                    updateLog.put(name, getter.invoke(device).toString());
//                    System.out.println(name + " " + map.get(name));
                }
                if(setter != null)
                    setter.invoke(device, map.get(name));
            }
        }
        device = updateDeviceById(id, device);
        LogRecord.appendLog(id, updateLog);
        return device != null;

    }

    @PostMapping("dynamic_search")
    @ResponseBody
    List<DeviceEntity> getDynamicSearchResult(@RequestBody JSONArray data){
        return dynamicSelect(data);
    }


}
