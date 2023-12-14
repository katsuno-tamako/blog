package com.neko.neko.Dao.PhotographDao;

import java.util.List;
import com.neko.neko.POJO.PO.photographPO.PhotographPO;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographDao {

    public void insertPhoto(PhotographPO photographPO);

    public List<PhotographPO> selectPhotoByAlbum(String album);

    public void deleteAlbumImageByPid(int pid);


}
