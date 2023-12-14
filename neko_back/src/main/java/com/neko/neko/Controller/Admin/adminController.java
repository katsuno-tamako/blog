package com.neko.neko.Controller.Admin;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.neko.neko.POJO.PO.adminPO.AdminPO;
import com.neko.neko.POJO.PO.adminPO.IndexInfoPO;
import com.neko.neko.POJO.PO.articlesPO.Article_gradePO;
import com.neko.neko.POJO.PO.articlesPO.ArticlesPO;
import com.neko.neko.POJO.PO.articlesPO.labelPO;
import com.neko.neko.POJO.VO.adminVO.receiveArticlesVO;
import com.neko.neko.Service.AdminService.AdminService;
import com.neko.neko.Service.AdminService.IndexInfoService;
import com.neko.neko.Service.ArticleService.ArticleService;
import com.neko.neko.Service.ArticleService.Article_gradeService;
import com.neko.neko.Service.ArticleService.LabelService;
import com.neko.neko.config.otPack;
import com.neko.neko.config.responseCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class adminController {

    @Resource
    ArticlesPO articlesPO;

    @Resource
    LabelService labelService;

    @Resource
    responseCode response;

    @Resource
    ArticleService articleService;

    @Resource
    otPack ot;

    @Resource
    AdminService adminService;

    @Resource
    AdminPO adminPO;

    @RequestMapping("/adminTest")
    public void adminTest(){
        System.out.println("test");
    }

    @RequestMapping("/adminLogin")
    public responseCode adminLogin(@RequestBody AdminPO admin, HttpSession session){
        System.out.println(admin);
        adminPO = adminService.selectAdminAccount(admin);
        System.out.println(adminPO);
        if(adminPO != null){
            System.out.println(adminPO);
            session.setAttribute("admin", adminPO);
            response.setCode("200");
            response.setMessage("Admin Login Success");
            System.out.println("Admin Login Success");
            return response;
        }

        System.out.println("error");
        response.setCode("500");
        response.setMessage("Admin Login Error");
        return response;
    }

    @RequestMapping("/JWLogin")
    public String JWLogin(HttpSession session){
        try {
            if(session.getAttribute("admin") != null){
                return "1";
            }
        }catch (Exception e){
            return "0";
        }
        return "0";
    }


    @Resource
    Article_gradeService article_gradeService;

    @Resource
    Article_gradePO article_gradePO;

    @RequestMapping("/receiveArticles")
    public responseCode receiveArticles(@RequestBody receiveArticlesVO article,HttpSession session){
        String articleLabel = "";
        for(int i=0; i<article.getContext_label().size();i++){
            articleLabel = articleLabel + article.getContext_label().get(i)+";";
        }
        adminPO = (AdminPO) session.getAttribute("admin");
        articlesPO.setAdminName(adminPO.getAdminName());
        articlesPO.setDate(ot.getDate());
        articlesPO.setContext_label(articleLabel);
        articlesPO.setContext(article.getContext());
        articlesPO.setContext_mainTitle(article.getContext_mainTitle());
        articlesPO.setContext_subTitle(article.getContext_subTitle());
        articlesPO.setIsComment(article.getIsComment());
        articlesPO.setIsCover(article.getIsCover());
        articlesPO.setMainClassify(article.getChooseMainClassify());
        articlesPO.setSubClassify(article.getChooseSubClassify());
        articlesPO.setArticleId(ot.getFN("NA"));
        articlesPO.setCoverImg(article.getCoverImg());
        articlesPO.setAdminId(adminPO.getAdminId());
        System.out.println(articlesPO);
        articleService.insertArticle(articlesPO);
        System.out.println(articlesPO.getArticleId());
        article_gradePO.setArticleId(articlesPO.getArticleId());
        article_gradePO.setClickNum("0");
        article_gradePO.setThumb_up("0");
        System.out.println(article_gradePO);
        article_gradeService.addInfo(article_gradePO);
        return response;
    }

    @CrossOrigin
    @PostMapping("/pid")
    @ResponseBody
    public responseCode upload(MultipartHttpServletRequest mRequest, HttpServletRequest request) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePrefix = dateFormat.format(new Date());
        String savePath = "src\\main\\resources\\static\\img\\";

        File folder = new File(savePath + datePrefix);

        System.out.println("folder of File is : " + folder);

        System.out.println("folder file name : " + folder.getName());
        System.out.println("folder exists is : " + folder.exists());
        System.out.println(folder.getName());
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }

        String originationName = mRequest.getFile("image").getOriginalFilename();

        String saveName = UUID.randomUUID().toString() + originationName.substring(originationName.lastIndexOf("."), originationName.length());
        String absolutePath = folder.getAbsolutePath();

        System.out.println("absolutePath : " + absolutePath);
        System.out.println("---1---");
        try {
            File fileToSave = new File(absolutePath + File.separator + saveName);
            System.out.println(fileToSave);
            mRequest.getFile("image").transferTo(fileToSave);
            String returnPath = request.getScheme() + "://"
                    +
                    request.getServerName() + ":" + request.getServerPort()
                    + "/img/"
                    + datePrefix + "/" + saveName;
            this.response.setCode("200");
            this.response.setMessage("SUCCESS");
            this.response.setUrl(returnPath);
            System.out.println("response:" + response);
            System.out.println("---2---");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.response.setCode("500");
        this.response.setMessage("ERROR");
        this.response.setUrl(null);
        System.out.println("---3---");
        return response;
    }
    @RequestMapping("/selectAllLabel")
    public List<labelPO> selectAllLabel(){
        return labelService.selectAllLabel();
    }

    @RequestMapping("/insertLabel")
    public void insertLabel(@RequestBody labelPO labelV){
        labelService.insertLabel(labelV);
    }

    @RequestMapping("/deleteLabel")
    public void deleteLabel(@RequestParam int id){
        labelService.deleteLabel(id);
    }


    @Resource
    IndexInfoService indexInfoService;

    @RequestMapping("/selectAllIndexInfo")
    public IndexInfoPO selectAllIndexInfo(){
        return indexInfoService.selectAllIndexInfo();
    }

    @RequestMapping("/updateIndexInfo")
    public void updateIndexInfo(@RequestBody IndexInfoPO indexInfoPO){
        indexInfoService.updateIndexInfo(indexInfoPO);
    }

    @RequestMapping("/changePassword")
    public void changePassword(@RequestParam String newPassword,HttpSession session){
        adminPO = (AdminPO) session.getAttribute("admin");
        adminPO.setAdminPassword(newPassword);
        System.out.println(adminPO);
        adminService.changePassword(adminPO);
    }


    @RequestMapping("/detemineAdmin")
    public String detemineAdmin(HttpSession session){
        adminPO = (AdminPO) session.getAttribute("admin");
        System.out.println(adminPO.getAuthority());
        return adminPO.getAuthority();
    }

    @RequestMapping("/returnAdminInfo")
    public AdminPO returnAdminInfo(HttpSession session){
        adminPO = (AdminPO) session.getAttribute("admin");
        System.out.println(adminPO);
        return adminPO;
    }


    @RequestMapping("/removeSession")
    public void removeSession(HttpSession session){
        session.removeAttribute("admin");
    }



    @CrossOrigin
    @PostMapping("/uploadAvatar")
    public responseCode uploadAvatar(MultipartFile file, HttpServletRequest request,HttpSession session){
        String savePath = "src\\main\\resources\\static\\img\\";
        String carousel = "Avatar";
        System.out.println(file.getOriginalFilename());
        File folder = new File(savePath + carousel);
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
                    "/img/"
                            + carousel + "/" + saveName;
            this.response.setCode("200");
            this.response.setMessage("SUCCESS");
            this.response.setUrl(returnPath);
            this.response.setLocalUrl(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());
            System.out.println("response:" + response);
            System.out.println("---2---");
            return response;
        }catch (Exception e){
            System.out.println(e);
        }
        return response;
    }


    @RequestMapping("/updateAvatar")
    public void updateAvatar(@RequestBody AdminPO admin,HttpSession session){
        adminPO = (AdminPO) session.getAttribute("admin");

        System.out.println("updateAvatar"+adminPO);
        admin.setAdminId(adminPO.getAdminId());
        adminService.changeImg(admin);
    }

    @RequestMapping("/getAvatar")
    public String getAvatar(HttpSession session){
        adminPO = (AdminPO) session.getAttribute("admin");
        return adminService.getAvatar(adminPO.getAdminId());
    }

    @RequestMapping("/selectAdmin")
    public AdminPO selectAdmin(HttpSession session){
        adminPO = (AdminPO) session.getAttribute("admin");

        return adminService.selectAdminByAdminId(adminPO.getAdminId());
    }

    @RequestMapping("/changeName")
    public void changeName(HttpSession session,@RequestParam String newName){
        adminPO = (AdminPO) session.getAttribute("admin");
        adminPO.setAdminName(newName);
        System.out.println(adminPO);
        adminService.changeName(adminPO);
    }

}
