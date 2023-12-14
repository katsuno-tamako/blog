package com.neko.neko.Service.ArticleService.impl;

import com.neko.neko.Dao.ArticleDao.ArticleClassifyDao;
import com.neko.neko.POJO.PO.articlesPO.ArticleClassifyPO;
import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import com.neko.neko.Service.ArticleService.ArticleClassifyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class ArticleClassifyImpl implements ArticleClassifyService {

    @Resource
    ArticleClassifyDao articleClassifyDao;

    @Override
    public List<ArticleClassifyPO> selectArticleClassify(String cid) {
        return articleClassifyDao.selectArticleClassify(cid);
    }

    @Override
    public void insertArticleClassify(ArticleClassifyPO articleClassifyPO) {
        articleClassifyDao.insertArticleClassify(articleClassifyPO);
    }

    @Override
    public List<ArticleClassifyPO> selectAllArticleClassify() {
        return articleClassifyDao.selectAllArticleClassify();
    }

    @Override
    public void deleteSubClassify(String cid) {
        articleClassifyDao.deleteSubClassify(cid);
    }

    @Override
    public List<SubClassifyPO> selectSubClassify(String cid) {
        return articleClassifyDao.selectSubClassify(cid);
    }

    @Override
    public void deleteMainClassify(String cid) {
        articleClassifyDao.deleteMainClassify(cid);
    }

    @Override
    public String selectCidByMainClassify(String classifyName) {
        return articleClassifyDao.selectCidByMainClassify(classifyName);
    }
}
