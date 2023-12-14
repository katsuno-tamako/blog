package com.neko.neko.POJO.PO.DatabasePO;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class DBPO implements Serializable {

    public int DId;
    public String DName;
    public String MainDClssify;
    public String SubDClassify;
    public String DContent;
    public String DataId;

    public int getDId() {
        return DId;
    }

    public void setDId(int DId) {
        this.DId = DId;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getMainDClssify() {
        return MainDClssify;
    }

    public void setMainDClssify(String mainDClssify) {
        MainDClssify = mainDClssify;
    }

    public String getSubDClassify() {
        return SubDClassify;
    }

    public void setSubDClassify(String subDClassify) {
        SubDClassify = subDClassify;
    }

    public String getDContent() {
        return DContent;
    }

    public void setDContent(String DContent) {
        this.DContent = DContent;
    }

    public String getDataId() {
        return DataId;
    }

    public void setDataId(String dataId) {
        DataId = dataId;
    }

    @Override
    public String toString() {
        return "DBPO{" +
                "DId=" + DId +
                ", DName='" + DName + '\'' +
                ", MainDClssify='" + MainDClssify + '\'' +
                ", SubDClassify='" + SubDClassify + '\'' +
                ", DContent='" + DContent + '\'' +
                ", DataId='" + DataId + '\'' +
                '}';
    }
}
