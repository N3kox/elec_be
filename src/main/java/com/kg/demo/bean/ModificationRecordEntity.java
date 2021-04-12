package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("修饰记录")
public class ModificationRecordEntity {
    @Id
    private Long id;
    @Property("工作票号")
    private String recordNumber;
    @Property("所属大馈线")
    private String belongingRoute;
    @Property("记录状态")
    private String recordStatus;
    @Property("key_id")
    private String key_id;
    @Property("登记时间")
    private String registrationDate;
    @Property("专业性质")
    private String proType;
    @Property("检修类型")
    private String modificationType;
    @Property("工作班组")
    private String workClass;
    @Property("工作内容")
    private String workDetails;
    @Property("完成情况")
    private String finishingStatus;
    @Property("专业")
    private String pro;
    @Property("维护班组")
    private String modificationClassName;
    @Property("设备名称")
    private String deviceName;
    @Property("工作日期")
    private String workingDate;
    @Property("验收意见")
    private String acceptanceComments;
    @Property("修饰记录ID")
    private String modificationID;
    @Relationship(type = "验收人", direction = Relationship.Direction.OUTGOING)
    private Set<StaffEntity> accStaffs = new HashSet<>();
    @Relationship(type = "负责人", direction = Relationship.Direction.OUTGOING)
    private Set<StaffEntity> chargeStaffs = new HashSet<>();
    @Relationship(type = "修饰地点", direction = Relationship.Direction.OUTGOING)
    private Set<RouteLocationEntity> routes = new HashSet<>();
    @Relationship(type = "所属地市", direction = Relationship.Direction.OUTGOING)
    private Set<CompanyEntity> companyEntities = new HashSet<>();
    @Relationship(type = "对应", direction = Relationship.Direction.OUTGOING)
    private Set<WorkTicketEntity> workTicketEntities = new HashSet<>();

}
