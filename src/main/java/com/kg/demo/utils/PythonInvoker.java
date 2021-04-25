package com.kg.demo.utils;

import com.kg.demo.config.Static;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.Buffer;

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

    public static String anotherTestRunner() throws IOException, InterruptedException {
        System.out.println(Static.getAnacondaRunner("hello"));
        Process process = Runtime.getRuntime().exec(Static.getAnacondaRunner("tf_idf"));
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = in.readLine()) != null) {
//            System.out.println(line);
            sb.append(line);
        }
        in.close();
        process.waitFor();
        System.out.println("wait done");
        return sb.toString();
    }

    public static String anaTest1() {
        Runtime rt = null;
        Process process;
        try{
            rt = Runtime.getRuntime();
            process = rt.exec(Static.getAnacondaRunner("tf_idf"));
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));
            BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream(), "utf-8"));
            StringBuilder sb = new StringBuilder();
            StringBuilder sberr = new StringBuilder();
            String line = null, linerr = null;
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
            System.out.println(sb.toString());
            System.out.println(sberr.toString());
            return sb.toString();
        } catch (IOException i){
            i.printStackTrace();
        }
        return null;
    }

}
