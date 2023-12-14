package com.neko.neko.Service.PhotographService.impl;

import com.neko.neko.Dao.PhotographDao.AlbumsDao;
import com.neko.neko.POJO.PO.photographPO.AlbumsPO;
import com.neko.neko.Service.PhotographService.AlbumsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class AlbumsImpl implements AlbumsService {

    @Resource
    AlbumsDao albumsDao;

    @Override
    public void createNewAblums(AlbumsPO albumsPO) {
        albumsDao.createNewAblums(albumsPO);
    }

    @Override
    public List<AlbumsPO> selectAllAlbums() {
        return albumsDao.selectAllAlbums();
    }

    @Override
    public void updateAlbumCover(AlbumsPO albumsPO) {
        albumsDao.updateAlbumCover(albumsPO);
    }

    @Override
    public void deleteAlbumByAid(String albumId) {
        albumsDao.deleteAlbumByAid(albumId);
    }

    @Override
    public List<AlbumsPO> selectAlbumsAndImg() {
        return albumsDao.selectAlbumsAndImg();
    }
}
