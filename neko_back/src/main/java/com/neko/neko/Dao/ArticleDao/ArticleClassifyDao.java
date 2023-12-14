package com.neko.neko.Dao.ArticleDao;
import java.util.List;
import com.neko.neko.POJO.PO.articlesPO.ArticleClassifyPO;
import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleClassifyDao {

    public List<ArticleClassifyPO> selectArticleClassify(String cid);

    public void insertArticleClassify(ArticleClassifyPO articleClassifyPO);

    public List<ArticleClassifyPO> selectAllArticleClassify();

    public void deleteSubClassify(String cid);

    public List<SubClassifyPO> selectSubClassify(String cid);

    public void deleteMainClassify(String cid);

    public String selectCidByMainClassify(String classifyName);


}
