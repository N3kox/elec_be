package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
public class WorkOrderEntity {
    @Id
    private Long id;
    @Property("完成时间")
    private String finishDate;
    @Property("所属大馈线名称")
    private String belongingLocationName;
    @Property("是否关联计划")
    private String relatedToPlan;
    @Property("停电范围")
    private String elecStopRange;
    @Property("计划开始时间")
    private String planStartDate;
    @Property("任务单id")
    private String workOrderId;
    @Property("是否停电")
    private String elecStop;
    @Property("编制部门")
    private String department;
    @Property("计划结束时间")
    private String planStopDate;
    @Property("编制日期")
    private String planMadeDate;
    @Property("任务内容")
    private String missionDetail;

    @Relationship(type = "工单任务位置", direction = Relationship.Direction.OUTGOING)
    private Set<RouteLocationEntity> routeLocationEntities = new HashSet<>();
    @Relationship(type = "工单编制人", direction = Relationship.Direction.OUTGOING)
    private Set<StaffEntity> staffEntities = new HashSet<>();
    @Relationship(type = "工单所属公司", direction = Relationship.Direction.OUTGOING)
    private Set<CompanyEntity> companyEntities = new HashSet<>();
    @Relationship(type = "对应", direction = Relationship.Direction.OUTGOING)
    private Set<StandardTaskTicketEntity> standardTaskTicketEntities = new HashSet<>();
}
