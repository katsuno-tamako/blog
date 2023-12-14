package com.neko.neko.Service.ArticleService.impl;

import com.neko.neko.Dao.ArticleDao.ArticleDao;
import com.neko.neko.POJO.PO.articlesPO.ArticlesPO;
import com.neko.neko.Service.ArticleService.ArticleService;
import com.neko.neko.config.PageBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ArticleImpl implements ArticleService {

    @Resource
    ArticleDao articleDao;

    @Override
    public void insertArticle(ArticlesPO articlesPO) {
        articleDao.insertArticle(articlesPO);
    }

    @Override
    public List<ArticlesPO> selectAllArticles() {
        return articleDao.selectAllArticles();
    }

    @Override
    public ArticlesPO selectArticleById(String articleId) {
        return articleDao.selectArticleById(articleId);
    }

    @Override
    public void deleteArticleById(String articleId) {
        articleDao.deleteArticleById(articleId);
    }

    @Override
    public void updateArticleById(ArticlesPO articlesPO) {
        articleDao.updateArticleById(articlesPO);
    }

    @Override
    public List<ArticlesPO> selectArticlesByKey(String key) {
        return articleDao.selectArticlesByKey(key);
    }

    @Override
    public List<ArticlesPO> selectArticleByClassify(String classify) {
        return articleDao.selectArticleByClassify(classify);
    }

    @Override
    public List<ArticlesPO> selectArticleBySubClassify(String sub) {
        return articleDao.selectArticleBySubClassify(sub);
    }

    @Override
    public List<ArticlesPO> selectArticleOrderByClickNum() {
        return articleDao.selectArticleOrderByClickNum();
    }

    @Override
    public int selectArticNumber() {
        return articleDao.selectArticNumber();
    }

    @Override
    public List<ArticlesPO> selectArticleByLimit(PageBean pageBean) {
        return articleDao.selectArticleByLimit(pageBean);
    }
}
