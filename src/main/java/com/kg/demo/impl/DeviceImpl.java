package com.kg.demo.impl;

import com.alibaba.fastjson.JSONArray;
import com.kg.demo.bean.DeviceEntity;
import com.kg.demo.config.Static;
import com.kg.demo.repo.DeviceRepo;
import com.kg.demo.service.DeviceService;
import com.kg.demo.utils.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

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
        return found.subList(0, Math.min(found.size(), Static.maxReturn));
    }

    // 精准动态查询
    @Override
    public List<DeviceEntity> dynamicSelect(JSONArray data) {
        List<DeviceEntity> res = new ArrayList<>();
        Set<Long> s = new HashSet<>();
        try{
            for(int i = 0; i < data.size()&& res.size() < Static.maxReturn * 4; i++){
                Map<String, String> m = JsonHelper.getPropertiesKVMap(data.getJSONArray(i));
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
                List<DeviceEntity> searchResult = deviceRepo.findAll(example);
                for(int j = 0; j < searchResult.size() && res.size() < Static.maxReturn * 4; j++){
                    DeviceEntity cur = searchResult.get(j);
                    if(!s.contains(cur.getGid())){
                        s.add(cur.getGid());
                        res.add(cur);
                    }
                }
            }
            return res.subList(0, Math.min(res.size(), Static.maxReturn * 4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}