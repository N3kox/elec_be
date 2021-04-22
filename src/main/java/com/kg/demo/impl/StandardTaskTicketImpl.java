package com.kg.demo.impl;

import com.kg.demo.bean.StandardTaskTicketEntity;
import com.kg.demo.repo.StandardTaskTicketRepo;
import com.kg.demo.service.StandardTaskTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardTaskTicketImpl implements StandardTaskTicketService {
    @Autowired
    private StandardTaskTicketRepo standardTaskTicketRepo;

    @Override
    public List<StandardTaskTicketEntity> selectTaskTicketByStatus(boolean status) {
        return standardTaskTicketRepo.findByElecStop(!status ? "否" : "是");
    }

    @Override
    public StandardTaskTicketEntity selectTaskTicketByCode(String code) {
        return standardTaskTicketRepo.findFirstByCode(code);
    }

    @Override
    public Page<StandardTaskTicketEntity> selectTaskTicketByStatusTop(boolean status) {
        return standardTaskTicketRepo.findByElecStop(!status ? "否" : "是", PageRequest.of(0, 5));
    }

    @Override
    public StandardTaskTicketEntity updateTaskTicketById(Long id, StandardTaskTicketEntity ticket) {
        ticket.setGid(id);
        return standardTaskTicketRepo.save(ticket);
    }

    @Override
    public StandardTaskTicketEntity selectTaskTicketByGid(Long id) {
        return standardTaskTicketRepo.findByGid(id);
    }
}
