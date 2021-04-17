package com.kg.demo.impl;

import com.kg.demo.bean.ClassEntity;
import com.kg.demo.repo.ClassRepo;
import com.kg.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassImpl implements ClassService {
    @Autowired
    private ClassRepo classRepo;

    @Override
    public Page<ClassEntity> selectAllClass() {
        Pageable pageable = PageRequest.of(0, 5);
        return classRepo.findAll(pageable);
    }

    @Override
    public Page<ClassEntity> selectByName(String name) {
        return classRepo.findByClassName(name, PageRequest.of(0, 5));
    }
}
