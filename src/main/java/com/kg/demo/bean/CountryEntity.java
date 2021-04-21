package com.kg.demo.bean;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public class CountryEntity {
    @Id
    @GeneratedValue
    private Long gid;
    @Property("name")
    private String name;
}
