package com.kg.demo.repo;

import com.kg.demo.bean.DeviceEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface DeviceRepo extends Neo4jRepository<DeviceEntity, Long>, QueryByExampleExecutor<DeviceEntity> {
    Optional<DeviceEntity> findByGid(Long gid);
    List<DeviceEntity> findAll();
    List<DeviceEntity> findAll(Example deviceExample);
}
