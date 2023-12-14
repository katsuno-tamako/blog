package com.neko.neko.Dao.ArticleDao;
import java.util.List;
import com.neko.neko.POJO.PO.articlesPO.ArticlesPO;
import com.neko.neko.config.PageBean;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao {

    public void insertArticle(ArticlesPO articlesPO);

    public List<ArticlesPO> selectAllArticles();

    public ArticlesPO selectArticleById(String articleId);

    public void deleteArticleById(String articleId);

    public void updateArticleById(ArticlesPO articlesPO);

    public List<ArticlesPO> selectArticlesByKey(String key);

    public List<ArticlesPO> selectArticleByClassify(String classify);

    public List<ArticlesPO> selectArticleBySubClassify(String sub);

    public List<ArticlesPO> selectArticleOrderByClickNum();

    public int selectArticNumber();

    public List<ArticlesPO> selectArticleByLimit(PageBean pageBean);


}
