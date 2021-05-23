package com.kg.demo.impl;

import com.alibaba.fastjson.JSONArray;
import com.kg.demo.bean.DeviceEntity;
import com.kg.demo.repo.DeviceRepo;
import com.kg.demo.service.DeviceService;
import com.kg.demo.utils.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DeviceImpl implements DeviceService {
    @Autowired
    private DeviceRepo deviceRepo;

    @Override
    public DeviceEntity selectDeviceById(Long gid) {
        return deviceRepo.findById(gid).get();
    }

    @Override
    public DeviceEntity updateDeviceById(Long gid, DeviceEntity deviceEntity) {
        deviceEntity.setGid(gid);
        return deviceRepo.save(deviceEntity);
    }

    @Override
    public List<DeviceEntity> selectTop() {
        List<DeviceEntity> found = deviceRepo.findAll();
        List<DeviceEntity> res = new ArrayList<>();
        for(int i = 0; i < found.size() && i < 50; i++){
            res.add(found.get(i));
        }
        return res;
    }

    // 精准动态查询
    @Override
    public List<DeviceEntity> dynamicSelect(JSONArray data) {
        Map<String, String> m = JsonHelper.getPropertiesKVMap(data);
        try{
            DeviceEntity deviceEntity = new DeviceEntity();
            // 注入properties参数
            for(PropertyDescriptor p : Introspector.getBeanInfo(deviceEntity.getClass()).getPropertyDescriptors()) {
                String name = p.getName();
                if(m.containsKey(name)){
                    Method setter = p.getWriteMethod();
                    if(setter != null){
                        setter.invoke(deviceEntity, m.get(name));
                    }
                }
            }
            // 利用example查询相似项目
            Example<DeviceEntity> example = Example.of(deviceEntity);
            // "~ABC.*"
            List<DeviceEntity> res = deviceRepo.findAll(example);
            return res.subList(0, 75);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
// userid 登入时间戳 登出时间戳
// 登出 > 登入
// 1.同时在线人数,最多的值
// 2.峰值持续多久
// 秒
