package com.neko.neko.Service.PhotographService.impl;

import com.neko.neko.Dao.PhotographDao.AlbumCarouselDao;
import com.neko.neko.POJO.PO.photographPO.AlbumCarouselPO;
import com.neko.neko.Service.PhotographService.AlbumCarouselService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AlbumCarouselImpl implements AlbumCarouselService{

    @Resource
    AlbumCarouselDao albumCarouselDao;

    @Override
    public void insertImage(AlbumCarouselPO albumCarouselPO) {
        albumCarouselDao.insertImage(albumCarouselPO);
    }

    @Override
    public List<AlbumCarouselPO> selectImage() {
        return albumCarouselDao.selectImage();
    }

    @Override
    public void deleteAlbumCarousel(int id) {
        albumCarouselDao.deleteAlbumCarousel(id);
    }
}
