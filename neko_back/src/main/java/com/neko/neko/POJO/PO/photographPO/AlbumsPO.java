package com.neko.neko.POJO.PO.photographPO;

import org.springframework.stereotype.Component;
import java.util.List;
import java.io.Serializable;
@Component
public class AlbumsPO implements Serializable {

    private int aid;
    private String albumName;
    private String albumId;
    private String coverImage;
    private List<PhotographPO> photographPOList;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public List<PhotographPO> getPhotographPOList() {
        return photographPOList;
    }

    public void setPhotographPOList(List<PhotographPO> photographPOList) {
        this.photographPOList = photographPOList;
    }

    @Override
    public String toString() {
        return "AlbumsPO{" +
                "aid=" + aid +
                ", albumName='" + albumName + '\'' +
                ", albumId='" + albumId + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", photographPOList=" + photographPOList +
                '}';
    }
}
