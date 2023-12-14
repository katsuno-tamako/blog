package com.neko.neko.Service.ArticleService.impl;

import com.neko.neko.Dao.ArticleDao.ArticleLabelDao;
import com.neko.neko.POJO.PO.articlesPO.labelPO;
import com.neko.neko.Service.ArticleService.LabelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class LabelImpl implements LabelService {

    @Resource
    ArticleLabelDao articleLabelDao;

    @Override
    public List<labelPO> selectAllLabel() {
        return articleLabelDao.selectAllLabel();
    }

    @Override
    public void insertLabel(labelPO label) {
        articleLabelDao.insertLabel(label);
    }

    @Override
    public void deleteLabel(int id) {
        articleLabelDao.deleteLabel(id);
    }
}
