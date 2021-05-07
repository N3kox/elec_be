package com.kg.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.kg.demo.bean.StandardTaskTicketEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StandardTaskTicketService {
    List<StandardTaskTicketEntity> selectTaskTicketByStatus(boolean status);
    StandardTaskTicketEntity selectTaskTicketByCode(String code);
    Page<StandardTaskTicketEntity> selectTaskTicketByStatusTop(boolean status);
    StandardTaskTicketEntity selectTaskTicketByGid(Long id);
    StandardTaskTicketEntity updateTaskTicketById(Long id, StandardTaskTicketEntity ticket);
    List<StandardTaskTicketEntity> selectAllTicket();
    List<StandardTaskTicketEntity> dynamicSelect(JSONArray data);
}
