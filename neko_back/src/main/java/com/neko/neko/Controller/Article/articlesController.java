package com.neko.neko.Controller.Article;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.neko.neko.POJO.PO.adminPO.AdminPO;
import com.neko.neko.POJO.PO.articlesPO.ArticleClassifyPO;
import com.neko.neko.POJO.PO.articlesPO.ArticlesPO;
import com.neko.neko.POJO.PO.articlesPO.SubClassifyPO;
import com.neko.neko.POJO.VO.ArticleVO.ReturnArtIcleVO;
import com.neko.neko.POJO.VO.ArticleVO.ReturnOneArticleVO;
import com.neko.neko.Service.ArticleService.ArticleClassifyService;
import com.neko.neko.Service.ArticleService.ArticleService;
import com.neko.neko.Service.ArticleService.Article_gradeService;
import com.neko.neko.config.PageBean;
import com.neko.neko.config.responseCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/article")
public class articlesController {

    @Resource
    ArticleService articleService;

    @Resource
    responseCode response;

    @Resource
    ReturnArtIcleVO returnArtIcleVO;

    @RequestMapping("/selectAllArticle")
    public ReturnArtIcleVO selectAllArticle(HttpServletRequest request){
        returnArtIcleVO.setArticlesPOList(articleService.selectAllArticles());
        String url = request.getScheme() + "://"
                +
                request.getServerName() + ":" + request.getServerPort();
        returnArtIcleVO.setLocation(url);
        return returnArtIcleVO;
    }

    @Resource
    ReturnOneArticleVO returnOneArticleVO;

    @RequestMapping("/selectArticleById")
    public ReturnOneArticleVO selectArticleById(@RequestParam String articleId, HttpServletRequest request){
        String url = request.getScheme() + "://"
                +
                request.getServerName() + ":" + request.getServerPort();
        returnOneArticleVO.setLocation(url);
        returnOneArticleVO.setArticlesPO(articleService.selectArticleById(articleId));
        System.out.println(returnOneArticleVO);
        return returnOneArticleVO;
    }

    @RequestMapping("/uploadCover")
    @CrossOrigin
    public responseCode uploadCover(MultipartFile file,  HttpServletRequest request){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        String datePrefix = dateFormat.format(new Date());
        String savePath = "src\\main\\resources\\static\\img\\Article\\";

        System.out.println(file.getOriginalFilename());
        File folder = new File(savePath + datePrefix);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        String originationName = file.getOriginalFilename();

        String saveName = UUID.randomUUID().toString() + originationName.substring(originationName.lastIndexOf("."), originationName.length());
        String absolutePath = folder.getAbsolutePath();

        System.out.println("absoulte path : "+absolutePath);
        System.out.println("save name : "+saveName);

        try{
            File fileToSave = new File(absolutePath + File.separator + saveName);
            file.transferTo(fileToSave);
            String returnPath =
                     "/img/article/"
                    + datePrefix + "/" + saveName;
            this.response.setCode("200");
            this.response.setMessage("SUCCESS");
            this.response.setUrl(returnPath);
            System.out.println("response:" + response);
            System.out.println("---2---");
            return response;
        }catch (Exception e){
            System.out.println(e);
        }

        return response;
    }

    @Resource
    Article_gradeService article_gradeService;

    @RequestMapping("/deleteArticle")
    public void deleteArticle(@RequestParam String articleId){
        System.out.println("Preform delete article method , Article id is : " + articleId);
        article_gradeService.deleteInfo(articleId);
        articleService.deleteArticleById(articleId);
    }

    @RequestMapping("/updateArticleById")
    public void updateArticleById(@RequestBody ArticlesPO article){
        articleService.updateArticleById(article);
    }


    @Resource
    ArticleClassifyService articleClassifyService;

    @RequestMapping("/insertClassify")
    public void insertClassify(@RequestBody ArticleClassifyPO articleClassify){
        articleClassify.setCid(UUID.randomUUID().toString());
        articleClassifyService.insertArticleClassify(articleClassify);
    }

    @RequestMapping("/selectAllArticleClassify")
    public List<ArticleClassifyPO> selectAllArticleClassify(){
        return articleClassifyService.selectAllArticleClassify();
    }

    @RequestMapping("/selectArticleByCid")
    public List<ArticleClassifyPO> selectArticleByCid(@RequestParam String cid){
        return articleClassifyService.selectArticleClassify(cid);
    }

    @RequestMapping("/deleteSubClassify")
    public void deleteSubClassify(@RequestParam String cid){
        articleClassifyService.deleteSubClassify(cid);
    }


    @RequestMapping("/addMainClassify")
    public void addMainClassify(@RequestBody ArticleClassifyPO addMainClassify){
        System.out.println(addMainClassify);
    }


    @RequestMapping("/addSubClassify")
    public void addSubClassify(@RequestBody SubClassifyPO addSubClassify){
        System.out.println(addSubClassify);
    }

    @RequestMapping("/selectSubClassify")
    public List<SubClassifyPO> selectSubClassify(@RequestParam String cid){
        return articleClassifyService.selectSubClassify(cid);
    }

    @RequestMapping("/deleteMainClassify")
    public void deleteMainClassify(@RequestParam String cid){
        System.out.println(cid);
        articleClassifyService.deleteMainClassify(cid);
    }

    @RequestMapping("/selectArticlesByKey")
    public ReturnArtIcleVO selectArticlesByKey(@RequestParam String key,HttpServletRequest request){
        System.out.println("keyword is "+key);
        returnArtIcleVO.setArticlesPOList(articleService.selectArticlesByKey(key));
        String url = request.getScheme() + "://"
                +
                request.getServerName() + ":" + request.getServerPort();
        returnArtIcleVO.setLocation(url);
        return returnArtIcleVO;
    }

    @RequestMapping("/selectArticleByClassify")
    public ReturnArtIcleVO selectArticleByClassify(@RequestParam String classify,HttpServletRequest request){
        returnArtIcleVO.setArticlesPOList(articleService.selectArticleByClassify(classify));
        String url = request.getScheme() + "://"
                +
                request.getServerName() + ":" + request.getServerPort();
        returnArtIcleVO.setLocation(url);
        return returnArtIcleVO;
    }

    @RequestMapping("/selectArticleBySubClassify")
    public ReturnArtIcleVO selectArticleBySubClassify(@RequestParam String sub,HttpServletRequest request){
        returnArtIcleVO.setArticlesPOList(articleService.selectArticleBySubClassify(sub));
        String url = request.getScheme() + "://"
                +
                request.getServerName() + ":" + request.getServerPort();
        returnArtIcleVO.setLocation(url);
        return returnArtIcleVO;
    }


    @RequestMapping("/plusArticleClick")
    public void plusArticleClick(@RequestParam String articleId){
        article_gradeService.plusArticleClick(articleId);
    }

    @RequestMapping("/selectArticleOrderByClickNum")
    public List<ArticlesPO> selectArticleOrderByClickNum(){
        return articleService.selectArticleOrderByClickNum();
    }


    @RequestMapping("/selectArticNumber")
    public int selectArticNumber(){
        System.out.println(articleService.selectArticNumber());
        return articleService.selectArticNumber();
    }


    @Resource
    PageBean pageBean;


    @RequestMapping("/selectArticleByLimt")
    public List<ArticlesPO> selectArticleByLimt(@RequestParam int page, @RequestParam int size){
        System.out.println(page);
        System.out.println(size);
        pageBean.setFoot((page-1)*size+size);
        pageBean.setHead((page-1)*size);
        System.out.println(pageBean);
        System.out.println(articleService.selectArticleByLimit(pageBean));
        return articleService.selectArticleByLimit(pageBean);
    }


}
