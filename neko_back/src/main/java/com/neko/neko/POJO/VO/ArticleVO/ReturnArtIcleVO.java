package com.neko.neko.POJO.VO.ArticleVO;

import com.neko.neko.POJO.PO.articlesPO.ArticlesPO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.io.Serializable;
@Component
public class ReturnArtIcleVO implements Serializable {

    private List<ArticlesPO> articlesPOList;
    private String Location;

    public List<ArticlesPO> getArticlesPOList() {
        return articlesPOList;
    }

    public void setArticlesPOList(List<ArticlesPO> articlesPOList) {
        this.articlesPOList = articlesPOList;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "returnArtIcleVO{" +
                "articlesPOList=" + articlesPOList +
                ", Location='" + Location + '\'' +
                '}';
    }
}
