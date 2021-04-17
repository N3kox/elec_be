package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node("班组")
public class ClassEntity {
    @Id
    private long id;
    @Property("name")
    private String className;
//    @Relationship(type = "设备", direction = INCOMING)
//    private Set<DeviceEntity> devices = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

//    public Set<DeviceEntity> getDevices() {
//        return devices;
//    }
//
//    public void setDevices(Set<DeviceEntity> devices) {
//        this.devices = devices;
//    }
}
