package com.neko.neko.Controller.VisitorController;

import com.neko.neko.POJO.PO.adminPO.VisitorPO;
import com.neko.neko.Service.AdminService.VisitorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Calendar;

@RestController
@RequestMapping("/visitor")
public class visitorController {

    @Resource
    VisitorService visitorService;

    @Resource
    VisitorPO visitorPO;

    @RequestMapping("/plusVisitor")
    public void plusVisitor(@RequestParam String page){
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);
        String m = String.valueOf(year)+String.valueOf(month);
        System.out.println(m);

        visitorPO.setDate_month(m);
        if (page.equals("index")) {
            visitorPO.setIndex_num(1);
        }
        if(page.equals("album")){
            visitorPO.setAlbum_num(1);
        }
        if(page.equals("db")){
            visitorPO.setDb_num(1);
        }

        if(visitorService.selectVisitor(m) != null){
            visitorService.plus(visitorPO);
        }else {
            visitorService.add(visitorPO);
        }

    }


}
