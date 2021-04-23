package com.kg.demo.impl;

import com.kg.demo.bean.RouteLocationEntity;
import com.kg.demo.repo.RouteLocationRepo;
import com.kg.demo.service.RouteLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteLocationImpl implements RouteLocationService {
    @Autowired
    private RouteLocationRepo routeLocationRepo;
    @Override
    public RouteLocationEntity selectRouteById(Long id) {
        return routeLocationRepo.findById(id).get();
    }

    @Override
    public RouteLocationEntity updateRouteById(Long id, RouteLocationEntity routeLocationEntity) {
        routeLocationEntity.setId(id);
        return routeLocationRepo.save(routeLocationEntity);
    }
}
