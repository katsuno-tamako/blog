package com.neko.neko.Service.AdminService.impl;

import com.neko.neko.Dao.AdminDao.AdminDao;
import com.neko.neko.POJO.PO.adminPO.AdminPO;
import com.neko.neko.Service.AdminService.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AdminImpl implements AdminService {

    @Resource
    AdminDao adminDao;

    @Override
    public AdminPO selectAdminAccount(AdminPO adminPO) {
        return adminDao.selectAdminAccount(adminPO);
    }

    @Override
    public void changePassword(AdminPO adminPO) {
        adminDao.changePassword(adminPO);
    }

    @Override
    public List<AdminPO> selectAllAdminInfo() {
        return adminDao.selectAllAdminInfo();
    }

    @Override
    public void insertAdmin(AdminPO adminPO) {
        adminDao.insertAdmin(adminPO);
    }

    @Override
    public void deleteAdminAccount(String adminId) {
        adminDao.deleteAdminAccount(adminId);
    }

    @Override
    public void changeImg(AdminPO adminPO) {
        adminDao.changeImg(adminPO);
    }

    @Override
    public String getAvatar(String adminId) {
        return adminDao.getAvatar(adminId);
    }

    @Override
    public AdminPO selectAdminByAdminId(String adminId) {
        return adminDao.selectAdminByAdminId(adminId);
    }

    @Override
    public void changeName(AdminPO adminPO) {
        adminDao.changeName(adminPO);
    }
}
