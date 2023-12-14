package com.neko.neko.Service.AdminService.impl;

import com.neko.neko.Dao.VisitorDao.VisitorDao;
import com.neko.neko.POJO.PO.adminPO.VisitorPO;
import com.neko.neko.Service.AdminService.VisitorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class VisitorImpl implements VisitorService {

    @Resource
    VisitorDao visitorDao;


    @Override
    public VisitorPO selectVisitor(String date_month) {
        return visitorDao.selectVisitor(date_month);
    }

    @Override
    public void add(VisitorPO visitorPO) {
        visitorDao.add(visitorPO);
    }

    @Override
    public void plus(VisitorPO visitorPO) {
        visitorDao.plus(visitorPO);
    }
}
