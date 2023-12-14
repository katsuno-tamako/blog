package com.neko.neko.Service.AdminService.impl;

import com.neko.neko.Dao.AdminDao.IndexInfoDao;
import com.neko.neko.POJO.PO.adminPO.IndexInfoPO;
import com.neko.neko.Service.AdminService.IndexInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class IndexInfoImpl implements IndexInfoService {

    @Resource
    IndexInfoDao indexInfoDao;

    @Override
    public IndexInfoPO selectAllIndexInfo() {
        return indexInfoDao.selectAllIndexInfo();
    }

    @Override
    public void updateIndexInfo(IndexInfoPO indexInfoPO) {
        indexInfoDao.updateIndexInfo(indexInfoPO);
    }
}
