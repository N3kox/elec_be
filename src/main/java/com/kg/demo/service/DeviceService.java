package com.kg.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.kg.demo.bean.DeviceEntity;

import java.util.List;

public interface DeviceService {
    DeviceEntity selectDeviceById(Long gid);
    DeviceEntity updateDeviceById(Long gid, DeviceEntity deviceEntity);
    List<DeviceEntity> selectTop();
    List<DeviceEntity> dynamicSelect(JSONArray data);
}
