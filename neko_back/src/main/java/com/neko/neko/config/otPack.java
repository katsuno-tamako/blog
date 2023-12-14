package com.neko.neko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class otPack {

    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String date_toString = formatter.format(date).toString();
        return date_toString;
    }

    public String getFN(String head){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
        String i = formatter.format(date).toString();
        return head+i;
    }

    public String getStaticLocal(){
        return "D:\\code\\blog\\neko_back\\src\\main\\resources\\static";
    }


    public void deleteLocalImg(String path){
        String realInfo = null;
        int lastIndexOf = path.lastIndexOf("/");
        String img_path = path.substring(lastIndexOf+1, path.length());
        img_path = getStaticLocal() + path;
        System.out.println(img_path);
        File file = new File(img_path);
        if(file.exists()){
            System.out.println("Delete");
            file.delete();
        }else{
            System.out.println("Error");
        }
    }

}
