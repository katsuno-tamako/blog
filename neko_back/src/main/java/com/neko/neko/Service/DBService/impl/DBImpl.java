package com.neko.neko.Service.DBService.impl;

import com.neko.neko.Dao.DBDao.DBDao;
import com.neko.neko.POJO.PO.DatabasePO.DBPO;
import com.neko.neko.Service.DBService.DBService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DBImpl implements DBService {

    @Resource
    DBDao dbDao;

    @Override
    public void insertDB(DBPO dbpo) {
        dbDao.insertDB(dbpo);
    }

    @Override
    public List<DBPO> selectAllDB() {
        return dbDao.selectAllDB();
    }

    @Override
    public List<DBPO> selectDBByDName(String DName) {
        return dbDao.selectDBByDName(DName);
    }

    @Override
    public List<DBPO> selectDBByMainDClassify(String MainDClassify) {
        return dbDao.selectDBByMainDClassify(MainDClassify);
    }

    @Override
    public void UpdateDB(DBPO dbpo) {
        dbDao.UpdateDB(dbpo);
    }

    @Override
    public void DeleteDB(String DataId) {
        dbDao.DeleteDB(DataId);
    }

    @Override
    public DBPO selectDBByDBID(String DataId) {
        return dbDao.selectDBByDBID(DataId);
    }

    @Override
    public List<String> selectMainClassify() {
        return dbDao.selectMainClassify();
    }

    @Override
    public List<DBPO> selectDBByKeyword(String keyword) {
        return dbDao.selectDBByKeyword(keyword);
    }

    @Override
    public List<String> selectDBSubClassify(String MainDClssify) {
        return dbDao.selectDBSubClassify(MainDClssify);
    }

    @Override
    public List<DBPO> selectDBBySubClassify(String SubDClassify) {
        return dbDao.selectDBBySubClassify(SubDClassify);
    }
}
