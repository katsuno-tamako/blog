package com.neko.neko.POJO.PO.articlesPO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Article_gradePO implements Serializable {

    private int gid;
    private String articleId;
    private String clickNum;
    private String thumb_up;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getClickNum() {
        return clickNum;
    }

    public void setClickNum(String clickNum) {
        this.clickNum = clickNum;
    }

    public String getThumb_up() {
        return thumb_up;
    }

    public void setThumb_up(String thumb_up) {
        this.thumb_up = thumb_up;
    }

    @Override
    public String toString() {
        return "Article_gradePO{" +
                "gid=" + gid +
                ", articleId='" + articleId + '\'' +
                ", clickNum='" + clickNum + '\'' +
                ", thumb_up='" + thumb_up + '\'' +
                '}';
    }
}
