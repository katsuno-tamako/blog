package com.neko.neko.Dao.PhotographDao;
import java.util.List;
import com.neko.neko.POJO.PO.photographPO.AlbumsPO;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumsDao {

    public void createNewAblums(AlbumsPO albumsPO);

    public List<AlbumsPO> selectAllAlbums();

    public void updateAlbumCover(AlbumsPO albumsPO);

    public void deleteAlbumByAid(String albumId);

    public List<AlbumsPO> selectAlbumsAndImg();


}
