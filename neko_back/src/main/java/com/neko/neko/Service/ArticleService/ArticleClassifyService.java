package com.neko.neko.Service.ArticleService;

import com.neko.neko.POJO.PO.articlesPO.ArticleClassifyPO;
import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleClassifyService {

    public List<ArticleClassifyPO> selectArticleClassify(String cid);

    public void insertArticleClassify(ArticleClassifyPO articleClassifyPO);

    public List<ArticleClassifyPO> selectAllArticleClassify();

    public void deleteSubClassify(String cid);

    public List<SubClassifyPO> selectSubClassify(String cid);

    public void deleteMainClassify(String cid);

    public String selectCidByMainClassify(String classifyName);



}
