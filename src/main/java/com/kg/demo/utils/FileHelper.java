package com.kg.demo.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    public static String fileUpload(String dir, String name, MultipartFile file){
        if(dir == null || name == null || dir.length() == 0 || name.length() == 0) return null;
        try{
            File dest = new File(dir + name);
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return name;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
