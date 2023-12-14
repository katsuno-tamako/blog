package com.neko.neko.POJO.PO.adminPO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class AdminPO implements Serializable {

    private int id;
    private String adminAccount;
    private String adminPassword;
    private String adminId;
    private String adminName;
    private String adminImg;
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminImg() {
        return adminImg;
    }

    public void setAdminImg(String adminImg) {
        this.adminImg = adminImg;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "AdminPO{" +
                "id=" + id +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminImg='" + adminImg + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
