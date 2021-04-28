package com.kg.demo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kg.demo.bean.DeviceEntity;
import com.kg.demo.impl.DeviceImpl;
import org.springframework.web.bind.annotation.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

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
                res.add(p.getName());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping("dynamic")
    @ResponseBody
    List<DeviceEntity> getDynamicDeviceEntites(@RequestBody JSONArray data){
        return dynamicSelect(data);
    }


}
