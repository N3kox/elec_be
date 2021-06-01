package com.kg.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.kg.demo.bean.StandardTaskTicketEntity;
import com.kg.demo.impl.StandardTaskTicketImpl;
import com.kg.demo.utils.JsonHelper;
import com.kg.demo.utils.LogRecord;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kg.demo.utils.Lowercase.lowerCase;

@RestController
@RequestMapping("/mission_ticket")
public class StandardTaskTicketController extends StandardTaskTicketImpl {

    @GetMapping("/stop")
    @ResponseBody
    List<StandardTaskTicketEntity> getTaskTicketByStatus(@RequestParam("val") String stop){
//        System.out.println(stop);
        if(stop != null && stop.length() > 0){
            stop = lowerCase(stop);
            if(stop.equals("false") || stop.equals("true"))
                return selectTaskTicketByStatus(!stop.equals("false"));
        }
        return null;
    }

    @GetMapping("/all")
    @ResponseBody
    List<StandardTaskTicketEntity> getAllTicket(){
        return selectAllTicket();
    }

    @GetMapping("/first_code")
    @ResponseBody
    StandardTaskTicketEntity getTaskTicketByCode(@RequestParam("val") String code) {
//        System.out.println(code);
        return selectTaskTicketByCode(code);
    }

    //不返回page对象,仅返回content
    @GetMapping("/top_stop")
    @ResponseBody
    List<StandardTaskTicketEntity> getTaskTicketByStatusTop(@RequestParam("val") String stop){
        if(stop != null && stop.length() > 0){
            stop = lowerCase(stop);
            if(stop.equals("false") || stop.equals("true"))
                return selectTaskTicketByStatusTop(!stop.equals("false")).getContent();
        }
        return null;
    }

//    @PutMapping("/update/test")
//    @ResponseBody
//    public boolean updateTest1(@RequestBody JSONObject data){
//        Map<String, Object> userMap = JsonHelper.jsonObjectParser(data);
//        for(String key : userMap.keySet())
//            System.out.println(key + " " + userMap.get(key));
//        System.out.println("map对象:" + userMap.toString());
//        return true;
//    }

    /**
     * 更新节点并记录log
     * @param data 待更新属性map
     * @param id node id
     * @return 更新结果
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PutMapping("/update")
    @ResponseBody
    public boolean updateTask(@RequestBody JSONObject data, @RequestParam("id")Long id) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        StandardTaskTicketEntity ticket = selectTaskTicketByGid(id);
        if(ticket == null) return false;
        Map<String, Object> map = JsonHelper.jsonObjectParser(data);
        Map<String, Object> updateLog = new HashMap<>();
        PropertyDescriptor[] pd = Introspector.getBeanInfo(ticket.getClass()).getPropertyDescriptors();
        for(PropertyDescriptor p : pd) {
            String name = p.getName();
            if (!name.equals("gid") && map.containsKey(name)) {
                Method setter = p.getWriteMethod();
                Method getter = p.getReadMethod();
                if(getter != null && !map.get(name).equals(getter.invoke(ticket).toString())){
                    updateLog.put(name, getter.invoke(ticket).toString());
                }
                if (setter != null) {
                    setter.invoke(ticket, map.get(name));
                }
            }
        }
        ticket = updateTaskTicketById(id, ticket);
        LogRecord.appendLog(id, updateLog);
//        System.out.println("update task ticket done with id:" + id);
        return ticket != null;
    }

    @GetMapping("get_properties")
    @ResponseBody
    List<String> getTicketProperties(){
        List<String> res = new ArrayList<>();
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(StandardTaskTicketEntity.class);
            PropertyDescriptor[] pd = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor p : pd){
                if(p.getPropertyType().toString().equals("class java.lang.String"))
                    res.add(p.getName());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return res;
    }

    @PostMapping("dynamic_search")
    @ResponseBody
    List<StandardTaskTicketEntity> getDynamicSearchResult(@RequestBody JSONArray data){
        return dynamicSelect(data);
    }

    private static String getType(Object a){
        return a.getClass().toString();
    }

}
