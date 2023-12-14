package com.neko.neko.POJO.PO.photographPO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class AlbumCarouselPO implements Serializable {

    private int id;
    private String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "AlbumCarouselPO{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
