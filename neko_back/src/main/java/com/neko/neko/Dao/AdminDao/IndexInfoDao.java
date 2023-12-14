package com.neko.neko.Dao.AdminDao;

import com.neko.neko.POJO.PO.adminPO.IndexInfoPO;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexInfoDao {

    public IndexInfoPO selectAllIndexInfo();

    public void updateIndexInfo(IndexInfoPO indexInfoPO);

}
