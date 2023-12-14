package com.neko.neko.Service.AdminService;

import com.neko.neko.POJO.PO.adminPO.IndexInfoPO;
import org.springframework.stereotype.Service;

@Service
public interface IndexInfoService {

    public IndexInfoPO selectAllIndexInfo();

    public void updateIndexInfo(IndexInfoPO indexInfoPO);

}
