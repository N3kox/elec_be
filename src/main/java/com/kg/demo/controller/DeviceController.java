package com.kg.demo.controller;

import com.kg.demo.bean.DeviceEntity;
import com.kg.demo.impl.DeviceImpl;
import org.springframework.web.bind.annotation.*;

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



}
