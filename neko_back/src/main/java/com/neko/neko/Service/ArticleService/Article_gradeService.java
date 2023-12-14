package com.neko.neko.Service.ArticleService;

import com.neko.neko.POJO.PO.articlesPO.Article_gradePO;
import org.springframework.stereotype.Service;

@Service
public interface Article_gradeService {

    public void addInfo(Article_gradePO article_gradePO);

    public void deleteInfo(String articleId);

    public void plusArticleClick(String articleId);


}
