package com.kg.demo.impl;

import com.kg.demo.bean.DeviceEntity;
import com.kg.demo.repo.DeviceRepo;
import com.kg.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        for(int i = 0; i < found.size() && i < 100; i++){
            res.add(found.get(i));
        }
        return res;
    }
}
