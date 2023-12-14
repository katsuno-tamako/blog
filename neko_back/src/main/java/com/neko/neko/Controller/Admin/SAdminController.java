package com.neko.neko.Controller.Admin;

import com.neko.neko.POJO.PO.adminPO.AdminPO;
import com.neko.neko.Service.AdminService.AdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;

@RestController
@RequestMapping("/SAdmin")
public class SAdminController {

    @Resource
    AdminService adminService;

    @RequestMapping("/selectAllAdminInfo")
    public List<AdminPO> selectAllAdminInfo(){
        return adminService.selectAllAdminInfo();
    }

    @RequestMapping("/insertAdmin")
    public void insertAdmin(@RequestBody AdminPO adminPO){
        adminPO.setAdminId(UUID.randomUUID().toString());
        adminService.insertAdmin(adminPO);
    }

    @RequestMapping("/deleteAdminAccount")
    public void deleteAdminAccount(@RequestParam String adminId){
        adminService.deleteAdminAccount(adminId);
    }

}
