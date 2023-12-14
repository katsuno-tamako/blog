package com.neko.neko.Controller.Test;

import com.neko.neko.POJO.PO.DatabasePO.DBPO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @RequestMapping("/test")
    public void test(@RequestBody DBPO dbpo){
        System.out.println(dbpo);
    }

}
