package com.neko.neko.POJO.VO.ArticleVO;

import com.neko.neko.POJO.PO.articlesPO.ArticlesPO;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class ReturnOneArticleVO implements Serializable {

    private ArticlesPO articlesPO;
    private String location;

    public ArticlesPO getArticlesPO() {
        return articlesPO;
    }

    public void setArticlesPO(ArticlesPO articlesPO) {
        this.articlesPO = articlesPO;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ReturnOneArticleVO{" +
                "articlesPO=" + articlesPO +
                ", location='" + location + '\'' +
                '}';
    }
}
