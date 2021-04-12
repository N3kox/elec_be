package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("电站线路")
public class RouteLocationEntity {
    @Id
    private Long id;
    @Property("变电站id")
    private String tranformerID;
    @Property("变电站名称")
    private String name;
    @Property("变电站电压等级")
    private String voltageLevel;
    @Property("站线名称")
    private String nameAno;
}
