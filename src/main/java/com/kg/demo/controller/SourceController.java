package com.kg.demo.controller;

import com.kg.demo.config.Static;
import com.kg.demo.utils.*;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Map;

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
    public String pyTest() {
       return PythonInvoker.anaTest1();
    }

    @PostMapping("/term_search")
    @ResponseBody
    public String termSearch(@RequestBody String term){
        return PythonInvoker.termSearchInterface(term);
    }

    @PostMapping("/term_search_exact")
    @ResponseBody
    public String termSearchExact(@RequestBody String term){
        return PythonInvoker.termSearchExactInterface(term);
    }

    @PostMapping("/csv_upload")
    @ResponseBody
    public boolean csvUpload(MultipartFile[] files, @RequestParam("type") String type) throws FileNotFoundException {
        String path = ResourceUtils.getURL(Static.fgetCsvUploadLogLocation()).getPath();
        int count = 0;
        for(MultipartFile f : files){
            if(f.getOriginalFilename() == null) continue;
            String newFileName = type +  "_" + MD5Helper.strToMd5(f.getOriginalFilename()) + "_" + DateHelper.getCurrentTime() +  ".csv";
            String res = FileHelper.fileUpload(path, newFileName, f);
            if(res == null) count++;
            else{
                System.out.println(res);
            }
        }
        System.out.println("Failed file count : " + count);
        return true;
    }

    @PostMapping("/solution_search")
    @ResponseBody
    public String solutionSearch(@RequestBody String problem){
        return PythonInvoker.solutionSearchInterface(problem);
    }

    @PostMapping("/log")
    @ResponseBody
    public String getNodeLog(@RequestParam("id")Long id){
        return LogRecord.readLog(id);
//        String res = LogRecord.readLog(id);
//        System.out.println(res);
//        return res;
    }

}
