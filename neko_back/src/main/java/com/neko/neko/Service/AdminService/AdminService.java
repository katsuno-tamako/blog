package com.neko.neko.Service.AdminService;

import com.neko.neko.POJO.PO.adminPO.AdminPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public AdminPO selectAdminAccount(AdminPO adminPO);

    public void changePassword(AdminPO adminPO);

    public List<AdminPO> selectAllAdminInfo();

    public void insertAdmin(AdminPO adminPO);

    public void deleteAdminAccount(String adminId);

    public void changeImg(AdminPO adminPO);

    public String getAvatar(String adminId);

    public AdminPO selectAdminByAdminId(String adminId);

    public void changeName(AdminPO adminPO);




}
