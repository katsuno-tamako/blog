package com.neko.neko.Dao.ArticleDao;
import java.util.List;
import com.neko.neko.POJO.PO.articlesPO.labelPO;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleLabelDao {

    public List<labelPO> selectAllLabel();

    public void insertLabel(labelPO label);

    public void deleteLabel(int id);

}
