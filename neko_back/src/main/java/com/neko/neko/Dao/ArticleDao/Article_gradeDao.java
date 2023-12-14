package com.neko.neko.Dao.ArticleDao;

import com.neko.neko.POJO.PO.articlesPO.Article_gradePO;
import org.springframework.stereotype.Repository;

@Repository
public interface Article_gradeDao {

    public void addInfo(Article_gradePO article_gradePO);

    public void deleteInfo(String articleId);

    public void plusArticleClick(String articleId);

}
