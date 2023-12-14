package com.neko.neko.Controller.PlugController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.InetAddress;

@RestController
@RequestMapping("/plug")
public class PlugController {

    @RequestMapping("/getDiskAllFile")
   public void getDiskAllFIle(){
       String path="D:\\code\\blog";
        File file = new File(path);
        File[] array=file.listFiles();
        System.out.println("file:"+file);
        System.out.println("array:"+array);
        for(int i=0;i<array.length;i++){
            if(array[i].isFile()){
                System.out.println("^^^^^^"+array[i].getName());
                System.out.println("^^^^^^"+array[i]);
            }else if(array[i].isDirectory()){
                System.out.println("IsFIle");
            }
        }
    }

}
