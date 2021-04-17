package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("员工")
public class StaffEntity {
    @Id
    private Long id;
    @Property("姓名")
    private String name;
//    @Relationship(type = "设备主人", direction = Relationship.Direction.INCOMING)
//    private Set<DeviceEntity> deviceEntities = new HashSet<>();
//    @Relationship(type = "就职", direction = Relationship.Direction.OUTGOING)
//    private Set<CompanyEntity> companyEntities = new HashSet<>();

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

//    public Set<DeviceEntity> getDeviceEntities() {
//        return deviceEntities;
//    }
//
//    public void setDeviceEntities(Set<DeviceEntity> deviceEntities) {
//        this.deviceEntities = deviceEntities;
//    }
//
//    public Set<CompanyEntity> getCompanyEntities() {
//        return companyEntities;
//    }
//
//    public void setCompanyEntities(Set<CompanyEntity> companyEntities) {
//        this.companyEntities = companyEntities;
//    }
//    @Relationship(type = "工单编制人", direction = Relationship.Direction.INCOMING)
//    private Set<WorkOrderEntity> workOrderEntities = new HashSet<>();
//    @Relationship(type = "任务单编制人", direction = Relationship.Direction.INCOMING)
//    private Set<StandardTaskTicketEntity> standardTaskTicketEntities = new HashSet<>();
//    @Relationship(type = "验收人", direction = Relationship.Direction.INCOMING)
//    private Set<ModificationRecordEntity> modificationRecordEntities = new HashSet<>();
}
