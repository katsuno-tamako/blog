package com.neko.neko.Dao.PhotographDao;

import com.neko.neko.POJO.PO.photographPO.AlbumCarouselPO;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AlbumCarouselDao {

    public void insertImage(AlbumCarouselPO albumCarouselPO);

    public List<AlbumCarouselPO> selectImage();

    public void deleteAlbumCarousel(int id);

}
