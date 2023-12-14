package com.neko.neko.Service.ArticleService;

import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SubClassifyService {

    public List<SubClassifyPO> selectSubClassify(String cid);

    public void addSubClassify(SubClassifyPO classifyPO);

    public void deleteSubClassify(int subid);

    public List<SubClassifyPO> selectSubClassifyByName(String classifyName);



}
