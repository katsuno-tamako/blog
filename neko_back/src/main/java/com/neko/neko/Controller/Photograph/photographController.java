package com.neko.neko.Controller.Photograph;

import com.neko.neko.Dao.PhotographDao.AlbumCarouselDao;
import com.neko.neko.POJO.PO.adminPO.AdminPO;
import com.neko.neko.POJO.PO.photographPO.AlbumCarouselPO;
import com.neko.neko.POJO.PO.photographPO.AlbumsPO;
import com.neko.neko.POJO.PO.photographPO.PhotographPO;
import com.neko.neko.POJO.VO.PhotographVO.PhotographVO;
import com.neko.neko.Service.PhotographService.AlbumCarouselService;
import com.neko.neko.Service.PhotographService.AlbumsService;
import com.neko.neko.Service.PhotographService.PhotographService;
import com.neko.neko.config.otPack;
import com.neko.neko.config.responseCode;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/photographController")
public class photographController {

    @Resource
    AlbumsService albumsService;

    @RequestMapping("/createNewAblums")
    public void createNewAblums(@RequestBody AlbumsPO albumsPO){

        albumsPO.setCoverImage("null");
        albumsPO.setAlbumId(UUID.randomUUID().toString());
        albumsService.createNewAblums(albumsPO);
    }

    @RequestMapping("/selectAllAlbums")
    public List<AlbumsPO> selectAllAlbums(){
        return albumsService.selectAllAlbums();
    }

    @Resource
    responseCode response;

    @Resource
    PhotographPO photographPO;

    @RequestMapping("/uploadPicture")
    @CrossOrigin
    public responseCode uploadPicture(MultipartFile file, HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        String datePrefix = dateFormat.format(new Date());
        String savePath = "src\\main\\resources\\static\\img\\Photograph\\";

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
                    "/img/Photograph/"
                            + datePrefix + "/" + saveName;
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

    @Resource
    AdminPO adminPO;

    @Resource
    otPack ot;

    @Resource
    PhotographService photographService;

    @Resource
    PhotographVO photographVO;

    @RequestMapping("/insertPhoto")
    public void insertPhoto(@RequestBody PhotographPO photograph, HttpSession session){
        photograph.setImageDate(ot.getDate());
        adminPO = (AdminPO) session.getAttribute("admin");
        photograph.setAuthor(adminPO.getAdminName());
        photographService.insertPhoto(photograph);
    }

    @RequestMapping("/selectPhotoByAlbum")
    public PhotographVO selectPhotoByAlbum(@RequestParam  String album,HttpServletRequest request){
        photographVO.setLocalURL(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());
        photographVO.setPhotographPOS(photographService.selectPhotoByAlbum(album));
        return photographVO;
    }

    @Resource
    AlbumsPO albumsPO;

    @RequestMapping("/setAlbumCover")
    public void setAlbumCover(@RequestParam String imagePath,@RequestParam String album){
        albumsPO.setAlbumId(album);
        albumsPO.setCoverImage(imagePath);
        System.out.println(albumsPO);
        albumsService.updateAlbumCover(albumsPO);
    }

    @RequestMapping("/deleteAlbumImageByPid")
    public void deleteAlbumImageByPid(@RequestParam int pid,@RequestParam String path,HttpServletRequest request) throws IOException {
        photographService.deleteAlbumImageByPid(pid);
        String realInfo = null;
        int lastIndexOf = path.lastIndexOf("/");
        String img_path = path.substring(lastIndexOf+1, path.length());
        img_path = ot.getStaticLocal() + path;
        System.out.println(img_path);
        File file = new File(img_path);
        if(file.exists()){
            System.out.println("Delete");
            file.delete();
        }else{
            System.out.println("Error");
        }

    }

    @RequestMapping("/deleteAlbumByAlbumId")
    public void deleteAlbumByAlbumId(@RequestParam String albumId){
        albumsService.deleteAlbumByAid(albumId);
    }


    @RequestMapping("/selectAlbumsAndImg")
    public List<AlbumsPO> selectAlbumsAndImg(){
        return albumsService.selectAlbumsAndImg();
    }



    @Resource
    AlbumCarouselService albumCarouselService;

    @RequestMapping("/insertImage")
    public void insertImage(@RequestBody AlbumCarouselPO albumCarouselPO){
        albumCarouselService.insertImage(albumCarouselPO);
    }

    @RequestMapping("/selectImage")
    public List<AlbumCarouselPO> selectImage(){
        return albumCarouselService.selectImage();
    }

    @Resource
    AlbumCarouselPO albumCarouselPO;

    @RequestMapping("/upImageToCarousel")
    @CrossOrigin
    public responseCode upImageToCarousel(MultipartFile file, HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        String datePrefix = dateFormat.format(new Date());
        String savePath = "src\\main\\resources\\static\\img\\Photograph\\";
        String carousel = "albumCarousel";
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
                    "/img/Photograph/"
                            + carousel + "/" + saveName;
            this.response.setCode("200");
            this.response.setMessage("SUCCESS");
            this.response.setUrl(returnPath);
            this.response.setLocalUrl(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort());
            System.out.println("response:" + response);
            System.out.println("---2---");

            albumCarouselPO.setPath(returnPath);
            albumCarouselService.insertImage(albumCarouselPO);

            return response;
        }catch (Exception e){
            System.out.println(e);
        }
        return response;
    }


    @RequestMapping("/deleteAlbumCarousel")
    public void deleteAlbumCarousel(@RequestParam int id,@RequestParam  String path){
        albumCarouselService.deleteAlbumCarousel(id);
        String realInfo = null;
        int lastIndexOf = path.lastIndexOf("/");
        String img_path = path.substring(lastIndexOf+1, path.length());
        img_path = ot.getStaticLocal() + path;
        System.out.println(img_path);
        File file = new File(img_path);
        if(file.exists()){
            System.out.println("Delete");
            file.delete();
        }else{
            System.out.println("Error");
        }
    }

}
