package com.kg.demo.utils;

import com.kg.demo.config.Static;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class PythonInvoker implements Serializable {

    /**
     * @throws IOException
     * @throws InterruptedException
     */
    public static String testRunner() throws IOException, InterruptedException{
//        String exe = "python3";
        String exe = Static.anacondaPython;
        String command = "/Users/mac/PycharmProjects/webSpider4KG/webSpider/src/interface.py";
        String a = "--new";
        String aa = "hello";
        String[] cmdArr = new String[]{exe, command, a, aa};
        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        process.waitFor();
        return str;
    }

    /**
     * python调用测试类
     * @return 测试结果
     * @throws IOException
     * @throws InterruptedException
     */
    public static String anotherTestRunner() throws IOException, InterruptedException {
        System.out.println(Static.getAnacondaRunner("hello"));
        Process process = Runtime.getRuntime().exec(Static.getAnacondaRunner("tf_idf"));
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
//            System.out.println(line);
            sb.append(line);
        }
        in.close();
        process.waitFor();
        System.out.println("wait done");
        return sb.toString();
    }

    /**
     * python调用测试类2
     * @return 测试结果
     */
    public static String anaTest1() {
        Runtime rt = null;
        Process process;
        try{
            rt = Runtime.getRuntime();
            process = rt.exec(Static.getAnacondaRunner("tf_idf"));
            return getString(process);
        } catch (IOException i){
            i.printStackTrace();
        }
        return null;
    }

    /**
     * 选定是否输出python error流
     * @param process
     * @return
     * @throws IOException
     */
    private static String getString(Process process) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
        BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        StringBuilder sberr = new StringBuilder();
        String line, linerr;
        while((line = in.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        while((linerr = err.readLine()) != null){
            sberr.append(linerr);
            sberr.append("\n");
        }
        in.close();
        err.close();
        System.out.println(sberr);
        return sb.toString();
    }

    /**
     * Python调用接口
     * @param map key:action; value: argument value
     * @return result from python
     */
    public static String myInvoke(Map<String, String> map){
        Runtime rt;
        Process process;
        try{
            rt = Runtime.getRuntime();
            process = rt.exec(Static.getArgsAnacondaRunner(map));
            return getString(process);
        } catch (IOException i){
            i.printStackTrace();
        }
        return null;
    }

    /**
     * 术语模糊查询接口
     * @param term 任意文本内容
     * @return 文本相关术语序列
     */
    public static String termSearchInterface(String term){
        Map<String, String> map = new HashMap<>();
        map.put("term-search", term);
        return myInvoke(map);
    }

    /**
     * 术语内容获取接口
     * @param term 直接术语
     * @return 术语介绍
     */
    public static String termSearchExactInterface(String term){
        Map<String, String> map = new HashMap<>();
        map.put("term-search-exact", term);
        return myInvoke(map);
    }

    /**
     * 问题搜索接口
     * @param problem 用户输入问题文本
     * @return 相关解决方案List
     */
    public static String solutionSearchInterface(String problem){
        Map<String, String> map = new HashMap<>();
        map.put("solution-search", problem);
        return myInvoke(map);
    }

}
