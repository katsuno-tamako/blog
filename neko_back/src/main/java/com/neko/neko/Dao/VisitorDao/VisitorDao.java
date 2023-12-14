package com.neko.neko.Dao.VisitorDao;

import com.neko.neko.POJO.PO.adminPO.VisitorPO;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorDao {

    public VisitorPO selectVisitor(String date_month);

    public void add(VisitorPO visitorPO);

    public void plus(VisitorPO visitorPO);

}
