package com.neko.neko.Service.PhotographService;

import com.neko.neko.POJO.PO.photographPO.AlbumsPO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AlbumsService {

    public void createNewAblums(AlbumsPO albumsPO);

    public List<AlbumsPO> selectAllAlbums();

    public void updateAlbumCover(AlbumsPO albumsPO);

    public void deleteAlbumByAid(String albumId);

    public List<AlbumsPO> selectAlbumsAndImg();


}
