package com.kg.demo.repo;

import com.kg.demo.bean.DeviceEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepo extends Neo4jRepository<DeviceEntity, Long> {
    Optional<DeviceEntity> findByGid(Long gid);
    List<DeviceEntity> findAll();
}
