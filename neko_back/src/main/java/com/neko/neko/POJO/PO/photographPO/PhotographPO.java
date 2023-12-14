package com.neko.neko.POJO.PO.photographPO;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class PhotographPO implements Serializable {

    private int pid;
    private String imagePath;
    private String imageName;
    private String imageClassify;
    private String imageIntroduction;
    private String imageDate;
    private String album;
    private String author;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageClassify() {
        return imageClassify;
    }

    public void setImageClassify(String imageClassify) {
        this.imageClassify = imageClassify;
    }

    public String getImageIntroduction() {
        return imageIntroduction;
    }

    public void setImageIntroduction(String imageIntroduction) {
        this.imageIntroduction = imageIntroduction;
    }

    public String getImageDate() {
        return imageDate;
    }

    public void setImageDate(String imageDate) {
        this.imageDate = imageDate;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "PhotographPO{" +
                "pid=" + pid +
                ", imagePath='" + imagePath + '\'' +
                ", imageName='" + imageName + '\'' +
                ", imageClassify='" + imageClassify + '\'' +
                ", imageIntroduction='" + imageIntroduction + '\'' +
                ", imageDate='" + imageDate + '\'' +
                ", album='" + album + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
