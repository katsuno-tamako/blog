package com.neko.neko.Service.AdminService;

import com.neko.neko.POJO.PO.adminPO.VisitorPO;
import org.springframework.stereotype.Service;

@Service
public interface VisitorService {

    public VisitorPO selectVisitor(String date_month);

    public void add(VisitorPO visitorPO);

    public void plus(VisitorPO visitorPO);

}
