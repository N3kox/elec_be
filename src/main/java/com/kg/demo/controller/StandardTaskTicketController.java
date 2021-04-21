package com.kg.demo.controller;

import com.kg.demo.bean.StandardTaskTicketEntity;
import com.kg.demo.impl.StandardTaskTicketImpl;
import com.kg.demo.utils.JsonHelper;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

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

    @PostMapping("/update/test")
    @ResponseBody
    public boolean updateGetter(@RequestBody JSONObject data){
        Map<String, Object> userMap = JsonHelper.jsonObjectParser(data);
        System.out.println("map对象:" + userMap.toString());
        return true;
    }

    // use this when you've got python3 environment rather than conda environment
    /*
    @GetMapping("pytest")
    void pytest() throws IOException, InterruptedException {
        PythonInvoker.testRunner();
    }
     */

}
