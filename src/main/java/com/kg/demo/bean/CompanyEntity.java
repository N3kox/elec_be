package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("运维商")
public class CompanyEntity {
    @Id
    private Long id;
    @Property("所属地市")
    private String name;
    @Relationship(type = "所属地市", direction = Relationship.Direction.INCOMING)
    private Set<DeviceEntity> deviceEntities = new HashSet<>();
    @Relationship(type = "就职", direction = Relationship.Direction.INCOMING)
    private Set<StaffEntity> staffEntities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DeviceEntity> getDeviceEntities() {
        return deviceEntities;
    }

    public void setDeviceEntities(Set<DeviceEntity> deviceEntities) {
        this.deviceEntities = deviceEntities;
    }

    public Set<StaffEntity> getStaffEntities() {
        return staffEntities;
    }

    public void setStaffEntities(Set<StaffEntity> staffEntities) {
        this.staffEntities = staffEntities;
    }
}
