package com.kg.demo.repo;

import com.kg.demo.bean.StandardTaskTicketEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface StandardTaskTicketRepo extends Neo4jRepository<StandardTaskTicketEntity, Long> {
    List<StandardTaskTicketEntity> findByElecStop(String status);
    StandardTaskTicketEntity findFirstByCode(String code);
}
