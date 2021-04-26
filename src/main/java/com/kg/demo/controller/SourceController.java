package com.kg.demo.controller;

import com.kg.demo.utils.JsonHelper;
import com.kg.demo.utils.PythonInvoker;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/source")
public class SourceController {
    @GetMapping("/term_json")
    @ResponseBody
    public String readJsonFile(@RequestParam("name")String fileName){
        return JsonHelper.readJsonFile(fileName);
    }

    @GetMapping("/py_test")
    @ResponseBody
    public String pyTest() throws IOException, InterruptedException {
       String res = PythonInvoker.anaTest1();
       System.out.println(res);
       return res;
    }

}
