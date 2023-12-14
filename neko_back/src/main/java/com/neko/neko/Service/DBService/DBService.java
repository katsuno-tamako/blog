package com.neko.neko.Service.DBService;

import com.neko.neko.POJO.PO.DatabasePO.DBPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DBService {

    public void insertDB(DBPO dbpo);

    public List<DBPO> selectAllDB();

    public List<DBPO> selectDBByDName(String DName);

    public List<DBPO> selectDBByMainDClassify(String MainDClassify);

    public void UpdateDB(DBPO dbpo);

    public void DeleteDB(String DataId);

    public DBPO selectDBByDBID(String DataId);

    public List<String> selectMainClassify();

    public List<DBPO> selectDBByKeyword(String keyword);

    public List<String> selectDBSubClassify(String MainDClssify);

    public List<DBPO> selectDBBySubClassify(String SubDClassify);




}
