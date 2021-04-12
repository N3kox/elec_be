package com.kg.demo.impl;

import com.kg.demo.bean.StandardTaskTicketEntity;
import com.kg.demo.repo.StandardTaskTicketRepo;
import com.kg.demo.service.StandardTaskTicketService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
