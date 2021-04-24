package com.kg.demo.config;

public class Static {
    public static String termJsonLocation = "/Users/mac/Desktop/毕设/数据/ws4mission/json/";
    public static String getTermJsonLocation(){
        return "file:"+termJsonLocation;
    }

    public static String pythonRuntimeLocation = "/Users/mac/PycharmProjects/webSpider4KG/webSpider/src/";
    public static String anacondaPython = "/opt/anaconda2/envs/py_bd/bin/python";
    public static String getAnacondaRunner(String fileName){
        return anacondaPython + " " + pythonRuntimeLocation + fileName + ".py";
    }
}
