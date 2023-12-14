package com.neko.neko.Service.ArticleService.impl;

import com.neko.neko.Dao.ArticleDao.ArticleClassifyDao;
import com.neko.neko.Dao.ArticleDao.SubClassifyDao;
import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import com.neko.neko.Service.ArticleService.SubClassifyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SubClassifyImpl implements SubClassifyService {

    @Resource
    SubClassifyDao subClassifyDao;

    @Override
    public List<SubClassifyPO> selectSubClassify(String cid) {
        return subClassifyDao.selectSubClassify(cid);
    }

    @Override
    public void addSubClassify(SubClassifyPO classifyPO) {
        subClassifyDao.addSubClassify(classifyPO);
    }

    @Override
    public void deleteSubClassify(int subid) {
        subClassifyDao.deleteSubClassify(subid);
    }

    @Override
    public List<SubClassifyPO> selectSubClassifyByName(String classifyName) {
        return subClassifyDao.selectSubClassifyByName(classifyName);
    }

}
