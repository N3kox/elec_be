package com.kg.demo.config;

import java.util.Map;

public class Static {
    public static int maxReturn = 150;
    private static String baseDir = "/Users/mac/Desktop/毕设/数据/ws4mission/";
    private static String termJsonLocation = baseDir + "json/";
    private static String csvUploadLogLocation = baseDir + "csvlog/";
    private static String logLocation = baseDir + "logs/";
    private static String anacondaPython = "/opt/anaconda2/envs/py_bd/bin/python";
    private static String pythonRuntimeLocation = "/Users/mac/PycharmProjects/webSpider4KG/webSpider/src/";
    public static String getTermJsonLocation(){
        return "file:"+termJsonLocation;
    }
    public static String fgetPythonRuntimeLocation(){
        return "file:"+pythonRuntimeLocation;
    }
    public static String fgetCsvUploadLogLocation(){ return "file:"+csvUploadLogLocation;}
    public static String fgetLogLocation(){
        return "file:" + logLocation;
    }
    public static String getAnacondaRunner(){
        return anacondaPython;
    }
    public static String getAnacondaRunner(String fileName){
        return anacondaPython + " " + pythonRuntimeLocation + fileName + ".py";
    }
    public static String getAnacondaMainRunner(){
        return getAnacondaRunner("interface");
    }
    public static String getArgsAnacondaRunner(Map<String, String> map){
        StringBuilder sb = new StringBuilder(getAnacondaMainRunner());
        for(String key : map.keySet()){
            // TODO : other actions
            if(key.equals("term-search") || key.equals("term-search-exact") || key.equals("solution-search")){
                sb.append(" --action ").append(key).append(" --val ").append(map.get(key));
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
}
