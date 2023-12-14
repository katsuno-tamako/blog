package com.neko.neko.Service.ArticleService.impl;

import com.neko.neko.Dao.ArticleDao.Article_gradeDao;
import com.neko.neko.POJO.PO.articlesPO.Article_gradePO;
import com.neko.neko.Service.ArticleService.Article_gradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class Article_gradeImpl implements Article_gradeService {

    @Resource
    Article_gradeDao article_gradeDao;

    @Override
    public void addInfo(Article_gradePO article_gradePO) {
        System.out.println(article_gradePO);
        article_gradeDao.addInfo(article_gradePO);
    }

    @Override
    public void deleteInfo(String articleId) {
        article_gradeDao.deleteInfo(articleId);
    }

    @Override
    public void plusArticleClick(String articleId) {
        article_gradeDao.plusArticleClick(articleId);
    }
}
