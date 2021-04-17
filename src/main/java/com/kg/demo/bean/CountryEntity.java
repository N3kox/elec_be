package com.kg.demo.bean;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public class CountryEntity {
    @Id
    private Long id;
    @Property("name")
    private String name;
}
