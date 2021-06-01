package com.kg.demo.repo;

import com.kg.demo.bean.StandardTaskTicketEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface StandardTaskTicketRepo extends Neo4jRepository<StandardTaskTicketEntity, Long>, QueryByExampleExecutor<StandardTaskTicketEntity> {
    List<StandardTaskTicketEntity> findByElecStop(String status);
    StandardTaskTicketEntity findFirstByCode(String code);
    Page<StandardTaskTicketEntity> findByElecStop(String status, Pageable page);

    StandardTaskTicketEntity findByGid(Long id);
    List<StandardTaskTicketEntity> findAll();
    List<StandardTaskTicketEntity> findAll(Example example);
}
