package com.kg.demo.repo;

import com.kg.demo.bean.RouteLocationEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface RouteLocationRepo extends Neo4jRepository<RouteLocationEntity, Long> {
    Optional<RouteLocationEntity> findById(Long id);
}
