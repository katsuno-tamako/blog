package com.neko.neko.Controller.Article;

import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import com.neko.neko.Service.ArticleService.ArticleClassifyService;
import com.neko.neko.Service.ArticleService.SubClassifyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/classify")
public class classifyController {

    @Resource
    SubClassifyService subClassifyService;

    @RequestMapping("/selectSubClassify")
    public List<SubClassifyPO> selectSubClassify(@RequestParam String cid){
        return subClassifyService.selectSubClassify(cid);
    }

    @RequestMapping("/SubClassifyPO")
    public void addSubClassify(@RequestBody SubClassifyPO addSubClassify){
        System.out.println(addSubClassify);
        subClassifyService.addSubClassify(addSubClassify);
    }

    @RequestMapping("/deleteSubClassify")
    public void deleteSubClassify(@RequestParam int subid){
        subClassifyService.deleteSubClassify(subid);
    }

    @Resource
    ArticleClassifyService articleClassifyService;

    @RequestMapping("/selectSubClassifyByName")
    public List<SubClassifyPO> selectSubClassifyByName(@RequestParam String classifyName){
        System.out.println(classifyName);
        String cid = articleClassifyService.selectCidByMainClassify(classifyName);
        System.out.println(cid);
        return subClassifyService.selectSubClassify(cid);
    }

}
