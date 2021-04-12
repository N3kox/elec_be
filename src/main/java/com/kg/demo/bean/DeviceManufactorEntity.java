package com.kg.demo.bean;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("生产厂家")
public class DeviceManufactorEntity {
    @Id
    private Long id;
    @Property("生产厂家")
    private String name;
}