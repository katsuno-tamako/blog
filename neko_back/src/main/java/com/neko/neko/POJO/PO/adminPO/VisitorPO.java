package com.neko.neko.POJO.PO.adminPO;

import org.springframework.stereotype.Component;
import java.io.Serializable;
@Component
public class VisitorPO implements Serializable {

    private int vid;
    private int index_num;
    private int db_num;
    private int album_num;
    private String date_month;

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getIndex_num() {
        return index_num;
    }

    public void setIndex_num(int index_num) {
        this.index_num = index_num;
    }

    public int getDb_num() {
        return db_num;
    }

    public void setDb_num(int db_num) {
        this.db_num = db_num;
    }

    public int getAlbum_num() {
        return album_num;
    }

    public void setAlbum_num(int album_num) {
        this.album_num = album_num;
    }

    public String getDate_month() {
        return date_month;
    }

    public void setDate_month(String date_month) {
        this.date_month = date_month;
    }

    @Override
    public String toString() {
        return "VisitorPO{" +
                "vid=" + vid +
                ", index_num=" + index_num +
                ", db_num=" + db_num +
                ", album_num=" + album_num +
                ", date_month='" + date_month + '\'' +
                '}';
    }
}
