package com.kg.demo.impl;

import com.alibaba.fastjson.JSONArray;
import com.kg.demo.bean.StandardTaskTicketEntity;
import com.kg.demo.repo.StandardTaskTicketRepo;
import com.kg.demo.service.StandardTaskTicketService;
import com.kg.demo.utils.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<StandardTaskTicketEntity> selectAllTicket() {
        return standardTaskTicketRepo.findAll();
    }

    @Override
    public List<StandardTaskTicketEntity> dynamicSelect(JSONArray data) {
        Map<String, String> m = JsonHelper.getPropertiesKVMap(data);
        try{
            StandardTaskTicketEntity standardTaskTicketEntity = new StandardTaskTicketEntity();
            for(PropertyDescriptor p : Introspector.getBeanInfo(standardTaskTicketEntity.getClass()).getPropertyDescriptors()){
                String name = p.getName();
                if(m.containsKey(name)){
                    Method setter = p.getWriteMethod();
                    if(setter != null)
                        setter.invoke(standardTaskTicketEntity, m.get(name));
                }
            }
            Example<StandardTaskTicketEntity> example = Example.of(standardTaskTicketEntity);
            List<StandardTaskTicketEntity> res = standardTaskTicketRepo.findAll(example);
            return res;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
