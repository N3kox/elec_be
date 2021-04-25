package com.kg.demo.controller;

import com.kg.demo.utils.JsonHelper;
import com.kg.demo.utils.PythonInvoker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/source")
public class SourceController {
    @RequestMapping("/term_json")
    @ResponseBody
    public String readJsonFile(@RequestParam("name")String fileName){
        return JsonHelper.readJsonFile(fileName);
    }

    @RequestMapping("/py_test")
    @ResponseBody
    public String pyTest() throws IOException, InterruptedException {
       String res = PythonInvoker.anaTest1();
       System.out.println(res);
       return res;
    }

}
