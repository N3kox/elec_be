package com.kg.demo.service;

import com.kg.demo.bean.ClassEntity;
import org.springframework.data.domain.Page;


public interface ClassService {
    Page<ClassEntity> selectAllClass();
    Page<ClassEntity> selectByName(String name);
}
