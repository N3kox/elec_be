package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node("设备")
public class DeviceEntity {
    @Id
    @GeneratedValue
    private Long gid;
    @Property("功能位置")
    private String functionalLocation;
    @Property("电压等级")
    private String voltageLevel;
    @Property("登记时间")
    private String registrationDate;
    @Property("资产编号")
    private String assetsCode;
    @Property("出厂日期")
    private String productionDate;
    @Property("电器铭牌运行库ID")
    private String nameplateCode;
    @Property("投运日期")
    private String commissioningDate;
    @Property("资产性质")
    private String assetsNature;

    @Property("工程编号")
    private String projectID;

    @Property("设备ID")
    private String deviceID;
    @Property("设备编码")
    private String deviceCode;
    @Property("专业分类")
    private String classification;
    @Property("设备增加方式")
    private String incrementalMethod;
    @Property("设备名称")
    private String name;
    @Property("运行编号")
    private String workingIdentifier;
    @Property("电压等级代码")
    private float voltageLevelCode;
    @Property("设备状态")
    private String deviceStatus;
    @Property("相数")
    private String phaseCount;
    @Property("latest_commissioning_date")
    private String latest_commissioning_date;
    @Property("相别")
    private String phase;
    @Property("PM编码")
    private String PMCode;
    @Property("remarks")
    private String remarks;
    @Relationship(type = "所属地市", direction = Relationship.Direction.OUTGOING)
    private Set<CompanyEntity> companyEntities = new HashSet<>();
    @Relationship(type = "维护班组", direction = Relationship.Direction.OUTGOING)
    private Set<ClassEntity> classEntities = new HashSet<>();
    @Relationship(type = "设备型号", direction = Relationship.Direction.OUTGOING)
    private Set<DeviceTypeCodeEntity> deviceTypeCodeEntities = new HashSet<>();
    @Relationship(type = "生产厂家", direction = Relationship.Direction.OUTGOING)
    private Set<DeviceManufactorEntity> deviceManufactorEntities = new HashSet<>();
    @Relationship(type = "制造国家", direction = Relationship.Direction.OUTGOING)
    private Set<CountryEntity> countryEntities = new HashSet<>();
    @Relationship(type = "设备类型", direction = Relationship.Direction.OUTGOING)
    private Set<DeviceTypeEntity> deviceTypeEntities = new HashSet<>();
    @Relationship(type = "变电站名称", direction = Relationship.Direction.OUTGOING)
    private Set<RouteLocationEntity> routeLocationEntities = new HashSet<>();
    @Relationship(type = "设备主人", direction = Relationship.Direction.OUTGOING)
    private Set<StaffEntity> staffEntities = new HashSet<>();

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getFunctionalLocation() {
        return functionalLocation;
    }

    public void setFunctionalLocation(String functionalLocation) {
        this.functionalLocation = functionalLocation;
    }

    public String getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(String voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getAssetsCode() {
        return assetsCode;
    }

    public void setAssetsCode(String assetsCode) {
        this.assetsCode = assetsCode;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getNameplateCode() {
        return nameplateCode;
    }

    public void setNameplateCode(String nameplateCode) {
        this.nameplateCode = nameplateCode;
    }

    public String getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(String commissioningDate) {
        this.commissioningDate = commissioningDate;
    }

    public String getAssetsNature() {
        return assetsNature;
    }

    public void setAssetsNature(String assetsNature) {
        this.assetsNature = assetsNature;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getIncrementalMethod() {
        return incrementalMethod;
    }

    public void setIncrementalMethod(String incrementalMethod) {
        this.incrementalMethod = incrementalMethod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getWorkingIdentifier() {
        return workingIdentifier;
    }

    public void setWorkingIdentifier(String workingIdentifier) {
        this.workingIdentifier = workingIdentifier;
    }

    public float getVoltageLevelCode() {
        return voltageLevelCode;
    }

    public void setVoltageLevelCode(float voltageLevelCode) {
        this.voltageLevelCode = voltageLevelCode;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getPhaseCount() {
        return phaseCount;
    }

    public void setPhaseCount(String phaseCount) {
        this.phaseCount = phaseCount;
    }

    public String getLatest_commissioning_date() {
        return latest_commissioning_date;
    }

    public void setLatest_commissioning_date(String latest_commissioning_date) {
        this.latest_commissioning_date = latest_commissioning_date;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getPMCode() {
        return PMCode;
    }

    public void setPMCode(String PMCode) {
        this.PMCode = PMCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Set<CompanyEntity> getCompanyEntities() {
        return companyEntities;
    }

    public void setCompanyEntities(Set<CompanyEntity> companyEntities) {
        this.companyEntities = companyEntities;
    }

    public Set<StaffEntity> getStaffEntities() {
        return staffEntities;
    }

    public void setStaffEntities(Set<StaffEntity> staffEntities) {
        this.staffEntities = staffEntities;
    }

    public Set<DeviceManufactorEntity> getDeviceManufactorEntities() {
        return deviceManufactorEntities;
    }

    public void setDeviceManufactorEntities(Set<DeviceManufactorEntity> deviceManufactorEntities) {
        this.deviceManufactorEntities = deviceManufactorEntities;
    }

    public Set<CountryEntity> getCountryEntities() {
        return countryEntities;
    }

    public void setCountryEntities(Set<CountryEntity> countryEntities) {
        this.countryEntities = countryEntities;
    }

    public Set<DeviceTypeEntity> getDeviceTypeEntities() {
        return deviceTypeEntities;
    }

    public void setDeviceTypeEntities(Set<DeviceTypeEntity> deviceTypeEntities) {
        this.deviceTypeEntities = deviceTypeEntities;
    }

    public Set<RouteLocationEntity> getRouteLocationEntities() {
        return routeLocationEntities;
    }

    public void setRouteLocationEntities(Set<RouteLocationEntity> routeLocationEntities) {
        this.routeLocationEntities = routeLocationEntities;
    }

    public Set<ClassEntity> getClassEntities() {
        return classEntities;
    }

    public void setClassEntities(Set<ClassEntity> classEntities) {
        this.classEntities = classEntities;
    }

    public Set<DeviceTypeCodeEntity> getDeviceTypeCodeEntities() {
        return deviceTypeCodeEntities;
    }

    public void setDeviceTypeCodeEntities(Set<DeviceTypeCodeEntity> deviceTypeCodeEntities) {
        this.deviceTypeCodeEntities = deviceTypeCodeEntities;
    }
}
