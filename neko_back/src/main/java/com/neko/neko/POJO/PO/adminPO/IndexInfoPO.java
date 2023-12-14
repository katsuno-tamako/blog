package com.neko.neko.POJO.PO.adminPO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class IndexInfoPO implements Serializable {

    private int Iid;
    private String Introduction;
    private String Email;
    private String GitHubUrl;
    private String QQ;
    private String BiliBili;
    private String weibo;

    public int getIid() {
        return Iid;
    }

    public void setIid(int iid) {
        Iid = iid;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGitHubUrl() {
        return GitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        GitHubUrl = gitHubUrl;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getBiliBili() {
        return BiliBili;
    }

    public void setBiliBili(String biliBili) {
        BiliBili = biliBili;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    @Override
    public String toString() {
        return "IndexInfoPO{" +
                "Iid=" + Iid +
                ", Introduction='" + Introduction + '\'' +
                '}';
    }
}
