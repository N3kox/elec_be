package com.kg.demo.service;

import com.kg.demo.bean.StandardTaskTicketEntity;

import java.util.List;

public interface StandardTaskTicketService {
    List<StandardTaskTicketEntity> selectTaskTicketByStatus(boolean status);
    StandardTaskTicketEntity selectTaskTicketByCode(String code);
}
