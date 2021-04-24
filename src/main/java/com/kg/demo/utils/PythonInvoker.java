package com.kg.demo.utils;

import com.kg.demo.config.Static;

import javax.xml.crypto.Data;
import java.io.*;

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
//        System.out.println(Static.getAnacondaRunner("tf_idf"));
        Process process = Runtime.getRuntime().exec(Static.getAnacondaRunner("tf_idf"));
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        in.close();
        process.waitFor();
        return sb.toString();
    }

}
