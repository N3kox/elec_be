package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node("设备类型")
public class DeviceTypeEntity {
    @Id
    @GeneratedValue
    private Long gid;
    @Property("name")
    private String deviceTypeName;
    @Property("类型编号")
    private String deviceTypeCode;

    @Relationship(type = "设备类型", direction = Relationship.Direction.INCOMING)
    private Set<DeviceEntity> devices = new HashSet<>();

    public Set<DeviceEntity> getDevices() {
        return devices;
    }

    public void setDevices(Set<DeviceEntity> devices) {
        this.devices = devices;
    }


    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    public String getDeviceTypeCode() {
        return deviceTypeCode;
    }

    public void setDeviceTypeCode(String deviceTypeCode) {
        this.deviceTypeCode = deviceTypeCode;
    }
}
