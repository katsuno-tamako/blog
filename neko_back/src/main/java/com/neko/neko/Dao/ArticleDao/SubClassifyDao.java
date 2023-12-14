package com.neko.neko.Dao.ArticleDao;

import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface SubClassifyDao {

    public List<SubClassifyPO> selectSubClassify(String cid);

    public List<SubClassifyPO> selectSubClassifyByName(String classifyName);

    public void addSubClassify(SubClassifyPO classifyPO);

    public void deleteSubClassify(int subid);




}
