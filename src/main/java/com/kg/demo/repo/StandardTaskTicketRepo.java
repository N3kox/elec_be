package com.kg.demo.repo;

import com.kg.demo.bean.StandardTaskTicketEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface StandardTaskTicketRepo extends Neo4jRepository<StandardTaskTicketEntity, Long>, QueryByExampleExecutor<StandardTaskTicketEntity> {
    List<StandardTaskTicketEntity> findByElecStop(String status);
    StandardTaskTicketEntity findFirstByCode(String code);
    Page<StandardTaskTicketEntity> findByElecStop(String status, Pageable page);

//    @Query("match(n) where id(n) = {id} set " +
//            "n.descSummary = :#{#ticket.descSummary}, " +
//            "n.descDetail = :#{#ticket.descDetail}, " +
//            "n.elecStopRange = :#{#ticket.elecStopRange}, " +
//            "n.location = :#{#ticket.location}, " +
//            "n.endingState = :#{#ticket.endingState}, " +
//            "n.belongingLocationName = :#{#ticket.belongingLocationName}, " +
//            "n.elecStop = :#{#ticket.elecStop}, " +
//            "n.relatedToPlan = :#{#ticket.relatedToPlan}, " +
//            "n.eliminateId = :#{#ticket.eliminateId}, " +
//            "n.preparedTime = :#{#ticket.preparedTime}, " +
//            "n.preparedDepartment = :#{#ticket.preparedDepartment}, " +
//            "n.code = :#{#ticket.code}, " +
//            "n.timeToStart = :#{#ticket.timeToStart} " +
//            "n.timeToEnd = :#{#timeToEnd} return n")
//    StandardTaskTicketEntity updateById(@Param("id")Long id, @Param("ticket")StandardTaskTicketEntity ticket);
    StandardTaskTicketEntity findByGid(Long id);
    List<StandardTaskTicketEntity> findAll();
    List<StandardTaskTicketEntity> findAll(Example example);
}
