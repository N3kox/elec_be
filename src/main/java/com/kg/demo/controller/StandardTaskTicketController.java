package com.kg.demo.controller;

import com.kg.demo.bean.StandardTaskTicketEntity;
import com.kg.demo.impl.StandardTaskTicketImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/code")
    @ResponseBody
    StandardTaskTicketEntity getTaskTicketByCode(@RequestParam("val") String code){
//        System.out.println(code);
        return selectTaskTicketByCode(code);
    }


}
