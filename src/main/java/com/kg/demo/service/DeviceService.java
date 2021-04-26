package com.kg.demo.service;

import com.kg.demo.bean.DeviceEntity;

import java.util.List;

public interface DeviceService {
    DeviceEntity selectDeviceById(Long gid);
    DeviceEntity updateDeviceById(Long gid, DeviceEntity deviceEntity);
    List<DeviceEntity> selectTop();
}
