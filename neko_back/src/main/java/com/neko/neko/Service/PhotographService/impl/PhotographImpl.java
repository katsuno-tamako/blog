package com.neko.neko.Service.PhotographService.impl;

import com.neko.neko.Dao.PhotographDao.PhotographDao;
import com.neko.neko.POJO.PO.photographPO.PhotographPO;
import com.neko.neko.Service.PhotographService.PhotographService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PhotographImpl implements PhotographService {

    @Resource
    PhotographDao photographDao;

    @Override
    public void insertPhoto(PhotographPO photographPO) {
        photographDao.insertPhoto(photographPO);
    }

    @Override
    public List<PhotographPO> selectPhotoByAlbum(String album) {
        return photographDao.selectPhotoByAlbum(album);
    }

    @Override
    public void deleteAlbumImageByPid(int pid) {
        photographDao.deleteAlbumImageByPid(pid);
    }
}
