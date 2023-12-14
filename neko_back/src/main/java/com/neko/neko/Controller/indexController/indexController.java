package com.neko.neko.Controller.indexController;

import com.neko.neko.POJO.PO.adminPO.VisitorPO;
import com.neko.neko.Service.AdminService.VisitorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Calendar;

@RestController
@RequestMapping("/index")
public class indexController {

    @Resource
    VisitorService visitorService;




}
