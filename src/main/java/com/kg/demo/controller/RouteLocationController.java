package com.kg.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.kg.demo.bean.RouteLocationEntity;
import com.kg.demo.impl.RouteLocationImpl;
import com.kg.demo.utils.JsonHelper;
import com.kg.demo.utils.LogRecord;
import org.springframework.web.bind.annotation.*;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/route_location")
public class RouteLocationController extends RouteLocationImpl {
    @PutMapping("/update")
    @ResponseBody
    public boolean updateRouteLocation(@RequestBody JSONObject data, @RequestParam("id") Long id) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        RouteLocationEntity route = selectRouteById(id);
        if(route == null) return false;
        Map<String, Object> map = JsonHelper.jsonObjectParser(data);
        Map<String, Object> updateLog = new HashMap<>();
        PropertyDescriptor[] pd = Introspector.getBeanInfo(route.getClass()).getPropertyDescriptors();
        for(PropertyDescriptor p : pd){
            String name = p.getName();
            if(!name.equals("gid") && map.containsKey(name)){
                Method setter = p.getWriteMethod();
                Method getter = p.getReadMethod();
                if(getter != null && !map.get(name).equals(getter.invoke(route).toString())){
                    updateLog.put(name, getter.invoke(route).toString());
                }
                if(setter != null)
                    setter.invoke(route, map.get(name));
            }
        }
        route = updateRouteById(id, route);
        LogRecord.appendLog(id, updateLog);
//        System.out.println("update routeLocation done with id : " + id);
        return route != null;
    }
}
