package com.neko.neko.Service.ArticleService;

import com.neko.neko.POJO.PO.articlesPO.labelPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LabelService {

    public List<labelPO> selectAllLabel();

    public void insertLabel(labelPO label);

    public void deleteLabel(int id);

}
