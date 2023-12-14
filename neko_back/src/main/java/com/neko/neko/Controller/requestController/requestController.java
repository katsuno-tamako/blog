package com.neko.neko.Controller.requestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/request")
public class requestController {

    @RequestMapping("/getLocal")
    public String getLocal(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
    }

}
