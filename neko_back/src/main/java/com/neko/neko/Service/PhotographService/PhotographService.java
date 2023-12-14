package com.neko.neko.Service.PhotographService;

import com.neko.neko.POJO.PO.photographPO.PhotographPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhotographService {

    public void insertPhoto(PhotographPO photographPO);

    public List<PhotographPO> selectPhotoByAlbum(String album);

    public void deleteAlbumImageByPid(int pid);

}
