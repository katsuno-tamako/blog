package com.neko.neko.POJO.PO.articlesPO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SubClassifyPO implements Serializable {

    private int subid;
    private String cid;
    private String subClassifyName;

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSubClassifyName() {
        return subClassifyName;
    }

    public void setSubClassifyName(String subClassifyName) {
        this.subClassifyName = subClassifyName;
    }

    @Override
    public String toString() {
        return "SubClassifyPO{" +
                "subid=" + subid +
                ", cid='" + cid + '\'' +
                ", subClassifyName='" + subClassifyName + '\'' +
                '}';
    }
}
