package com.neko.neko.Controller.DBController;

import com.neko.neko.POJO.PO.DatabasePO.DBPO;
import com.neko.neko.Service.DBService.DBService;
import com.neko.neko.config.otPack;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/DB")
public class dbController {

    @Resource
    otPack ot;

    @Resource
    DBPO db;

    @Resource
    DBService dbService;


    @RequestMapping("/insertDB")
    public void insertDB(@RequestBody  DBPO dbpo){
        dbpo.setDataId("db"+UUID.randomUUID().toString());
        System.out.println("Insert data : "+dbpo);
        dbService.insertDB(dbpo);
    }

    @RequestMapping("/selectAllDB")
    public List<DBPO> selectAllDB(){
        System.out.println("--");
        return dbService.selectAllDB();
    }

    @RequestMapping("/selectDBByDName")
    public List<DBPO> selectDBByDName(@RequestParam String DName){
        return dbService.selectDBByDName(DName);
    }

    @RequestMapping("/selectDBByDBID")
    public DBPO selectDBByDBID(@RequestParam String DataId){

        return dbService.selectDBByDBID(DataId);
    }


    @RequestMapping("/updateDB")
    public void updateDB(@RequestBody DBPO dbpo){
//        更新DB接收数据有问题，值未改变
        System.out.println("update data : "+dbpo);
        dbService.UpdateDB(dbpo);
    }

    @RequestMapping("/deleteDB")
    public void deleteDB(@RequestParam String DataId){
        dbService.DeleteDB(DataId);
    }


    @RequestMapping("/selectDBByDataId")
    public DBPO selectDBByDataId(@RequestParam String DataId){
        return dbService.selectDBByDBID(DataId);
    }


    @RequestMapping("/selectMainClassify")
    public List<String> selectMainClassify() {
        return dbService.selectMainClassify();
    }

    @RequestMapping("/selectDBByMainClassify")
    public List<DBPO> selectDBByMainClassify(@RequestParam String mainClassify){
        System.out.println(mainClassify);
        return dbService.selectDBByMainDClassify(mainClassify);
    }

    @RequestMapping("/selectDBByKeyword")
    public List<DBPO> selectDBByKeyword(@RequestParam String keyword) {
        return dbService.selectDBByKeyword(keyword);
    }

    @RequestMapping("/selectDBSubClassify")
    public List<String> selectDBSubClassify(@RequestParam String MainDClssify) {
        System.out.println("-"+MainDClssify);
        return dbService.selectDBSubClassify(MainDClssify);
    }

    @RequestMapping("/selectDBBySubClassify")
    public List<DBPO> selectDBBySubClassify(@RequestParam String SubDClassify){
        return dbService.selectDBBySubClassify(SubDClassify);
    }


}
