package com.neko.neko.Dao.AdminDao;

import com.neko.neko.POJO.PO.adminPO.AdminPO;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AdminDao {

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
