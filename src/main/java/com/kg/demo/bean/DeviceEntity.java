package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("设备")
public class DeviceEntity {
    @Id
    private Long id;
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
    private String voltageLevelCode;
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

}
