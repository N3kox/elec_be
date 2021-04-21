package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("工作票")
public class WorkTicketEntity {
    @Id
    @GeneratedValue
    private Long gid;
    @Property("票号")
    private String ticketNumber;
    @Property("票种类")
    private String ticketType_1;
    @Property("终结时间")
    private String terminateDate;
    @Property("工作班组人数")
    private String classCapacity;
    @Property("票状态")
    private String ticketStatue;
    @Property("key_id")
    private String key_id;
    @Property("计划开工时间")
    private String startDate;
    @Property("工作内容")
    private String workingDetails;
    @Property("制票部门")
    private String ticketDepartment;
    @Property("许可工作时间")
    private String allowedWorkingDate;
    @Property("计划结束时间")
    private String planedStopDate;
    @Property("票类型")
    private String ticketType_2;
    @Property("OBJ_ID")
    private String OBJ_ID;
}
