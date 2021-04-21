package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node("运维商")
public class CompanyEntity {
    @Id
    @GeneratedValue
    private Long gid;
    @Property("所属地市")
    private String name;

//    @Relationship(type = "所属地市", direction = Relationship.Direction.INCOMING)
//    private Set<DeviceEntity> deviceEntities = new HashSet<>();

    @Relationship(type = "就职", direction = Relationship.Direction.INCOMING)
    private Set<StaffEntity> staffEntities = new HashSet<>();

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<DeviceEntity> getDeviceEntities() {
//        return deviceEntities;
//    }
//
//    public void setDeviceEntities(Set<DeviceEntity> deviceEntities) {
//        this.deviceEntities = deviceEntities;
//    }

    public Set<StaffEntity> getStaffEntities() {
        return staffEntities;
    }

    public void setStaffEntities(Set<StaffEntity> staffEntities) {
        this.staffEntities = staffEntities;
    }
}
