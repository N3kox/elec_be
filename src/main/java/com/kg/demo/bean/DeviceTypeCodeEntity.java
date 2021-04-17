package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.HashSet;
import java.util.Set;

@Node("设备型号")
public class DeviceTypeCodeEntity {
    @Id
    private Long id;
    @Property("型号")
    private String typeCode;
//    @Relationship(type = "设备型号", direction = Relationship.Direction.INCOMING)
//    private Set<DeviceEntity> devices = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

//    public Set<DeviceEntity> getDevices() {
//        return devices;
//    }
//
//    public void setDevices(Set<DeviceEntity> devices) {
//        this.devices = devices;
//    }
}
