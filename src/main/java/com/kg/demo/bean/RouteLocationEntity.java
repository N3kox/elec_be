package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("电站线路")
public class RouteLocationEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Property("变电站id")
    private String tranformerID;
    @Property("变电站名称")
    private String name;
    @Property("变电站电压等级")
    private String voltageLevel;
    @Property("站线名称")
    private String nameAno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTranformerID() {
        return tranformerID;
    }

    public void setTranformerID(String tranformerID) {
        this.tranformerID = tranformerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(String voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public String getNameAno() {
        return nameAno;
    }

    public void setNameAno(String nameAno) {
        this.nameAno = nameAno;
    }
}
