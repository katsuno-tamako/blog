package com.neko.neko.POJO.PO.articlesPO;

import org.springframework.stereotype.Component;
import java.util.List;
import java.io.Serializable;

@Component
public class ArticleClassifyPO implements Serializable {

    private int id;
    private String classifyName;
    private int articleLevel;
    private String cid;
    private List<SubClassifyPO> subClassifyPOList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public int getArticleLevel() {
        return articleLevel;
    }

    public void setArticleLevel(int articleLevel) {
        this.articleLevel = articleLevel;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<SubClassifyPO> getSubClassifyPOList() {
        return subClassifyPOList;
    }

    public void setSubClassifyPOList(List<SubClassifyPO> subClassifyPOList) {
        this.subClassifyPOList = subClassifyPOList;
    }

    @Override
    public String toString() {
        return "ArticleClassifyPO{" +
                "id=" + id +
                ", classifyName='" + classifyName + '\'' +
                ", articleLevel=" + articleLevel +
                ", cid='" + cid + '\'' +
                ", subClassifyPOList=" + subClassifyPOList +
                '}';
    }
}
