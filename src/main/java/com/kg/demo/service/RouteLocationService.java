package com.kg.demo.service;

import com.kg.demo.bean.RouteLocationEntity;

public interface RouteLocationService {
    RouteLocationEntity selectRouteById(Long id);
    RouteLocationEntity updateRouteById(Long id, RouteLocationEntity routeLocationEntity);
}
