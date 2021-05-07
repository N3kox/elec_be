package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Node("标准工作任务单")
public class StandardTaskTicketEntity {
    @Id
    @GeneratedValue
    private Long gid;

    @Property("任务概述")
    private String descSummary;
    public StandardTaskTicketEntity(){}

    public StandardTaskTicketEntity(Long gid, String descSummary, String descDetail, String elecStopRange, String location, String endingState, String belongingLocationName, String elecStop, String relatedToPlan, String eliminateId, String preparedTime, String preparedDepartment, String code, String timeToStart, String timeToEnd) {
        this.gid = gid;
        this.descSummary = descSummary;
        this.descDetail = descDetail;
        this.elecStopRange = elecStopRange;
        this.location = location;
        this.endingState = endingState;
        this.belongingLocationName = belongingLocationName;
        this.elecStop = elecStop;
        this.relatedToPlan = relatedToPlan;
        this.eliminateId = eliminateId;
        this.preparedTime = preparedTime;
        this.preparedDepartment = preparedDepartment;
        this.code = code;
        this.timeToStart = timeToStart;
        this.timeToEnd = timeToEnd;
    }

    @Property("任务详述")
    private String descDetail;

    @Property("停电范围")
    private String elecStopRange;

    @Property("具体地点")
    private String location;

    @Property("完成阶段")
    private String endingState;

    @Property("所属大馈线名称")
    private String belongingLocationName;

    @Property("是否停电")
    private String elecStop;

    @Property("是否关联计划")
    private String relatedToPlan;

    @Property("消除编号")
    private String eliminateId;

    // 待定转换为date
    @Property("编制日期")
    private String preparedTime;

    @Property("编制部门")
    private String preparedDepartment;

    @Property("编号")
    private String code;

    @Property("计划开始时间")
    private String timeToStart;

    @Property("计划结束时间")
    private String timeToEnd;

    @Relationship(type = "任务位置", direction = OUTGOING)
    private Set<RouteLocationEntity> routeLocation = new HashSet<>();
    @Relationship(type = "任务单编制人", direction = OUTGOING)
    private Set<StaffEntity> missionTicketFounder = new HashSet<>();

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getDescSummary() {
        return descSummary;
    }

    public void setDescSummary(String descSummary) {
        this.descSummary = descSummary;
    }

    public String getDescDetail() {
        return descDetail;
    }

    public void setDescDetail(String descDetail) {
        this.descDetail = descDetail;
    }

    public String getElecStopRange() {
        return elecStopRange;
    }

    public void setElecStopRange(String elecStopRange) {
        this.elecStopRange = elecStopRange;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEndingState() {
        return endingState;
    }

    public void setEndingState(String endingState) {
        this.endingState = endingState;
    }

    public String getBelongingLocationName() {
        return belongingLocationName;
    }

    public void setBelongingLocationName(String belongingLocationName) {
        this.belongingLocationName = belongingLocationName;
    }

    public String getElecStop() {
        return elecStop;
    }

    public void setElecStop(String elecStop) {
        this.elecStop = elecStop;
    }

    public String getRelatedToPlan() {
        return relatedToPlan;
    }

    public void setRelatedToPlan(String relatedToPlan) {
        this.relatedToPlan = relatedToPlan;
    }

    public String getEliminateId() {
        return eliminateId;
    }

    public void setEliminateId(String eliminateId) {
        this.eliminateId = eliminateId;
    }

    public String getPreparedTime() {
        return preparedTime;
    }

    public void setPreparedTime(String preparedTime) {
        this.preparedTime = preparedTime;
    }

    public String getPreparedDepartment() {
        return preparedDepartment;
    }

    public void setPreparedDepartment(String preparedDepartment) {
        this.preparedDepartment = preparedDepartment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(String timeToStart) {
        this.timeToStart = timeToStart;
    }

    public String getTimeToEnd() {
        return timeToEnd;
    }

    public void setTimeToEnd(String timeToEnd) {
        this.timeToEnd = timeToEnd;
    }

    public Set<RouteLocationEntity> getRouteLocation() {
        return routeLocation;
    }

    public void setRouteLocation(Set<RouteLocationEntity> routeLocation) {
        this.routeLocation = routeLocation;
    }

    public Set<StaffEntity> getMissionTicketFounder() {
        return missionTicketFounder;
    }

    public void setMissionTicketFounder(Set<StaffEntity> missionTicketFounder) {
        this.missionTicketFounder = missionTicketFounder;
    }
}
