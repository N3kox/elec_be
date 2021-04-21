package com.kg.demo.utils;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;

public class PythonInvoker implements Serializable {
    /**
     * @throws IOException
     * @throws InterruptedException
     */
    public static void testRunner() throws IOException, InterruptedException{
        String exe = "python3";
        String command = "/Users/mac/PycharmProjects/webSpider4KG/webSpider/src/interface.py";
        String a = "--new";
        String aa = "hello";
        String[] cmdArr = new String[]{exe, command, a, aa};
        Process process = Runtime.getRuntime().exec(cmdArr);
        InputStream is = process.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String str = dis.readUTF();
        process.waitFor();
        System.out.println(str);
    }

}
