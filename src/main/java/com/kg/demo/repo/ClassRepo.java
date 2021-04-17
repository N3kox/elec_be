package com.kg.demo.repo;

import com.kg.demo.bean.ClassEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ClassRepo extends Neo4jRepository<ClassEntity, Long> {
    Page<ClassEntity> findAll(Pageable pageable);
    Page<ClassEntity> findByClassName(String name, Pageable page);
}
