package com.neko.neko.Service.PhotographService;

import com.neko.neko.POJO.PO.photographPO.AlbumCarouselPO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface AlbumCarouselService {

    public void insertImage(AlbumCarouselPO albumCarouselPO);

    public List<AlbumCarouselPO> selectImage();

    public void deleteAlbumCarousel(int id);



}


