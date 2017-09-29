package com.cenyol.example.test;

import com.cenyol.example.model.CodeEntity;
import com.cenyol.example.service.CoreService;

import java.util.List;

public class CodeTest {

    public static void main(String[] args) {
//      String pathName = "D:\\tomcat8\\webapps\\ROOT\\";
        String pathName = "D:\\IDEA\\txm\\src\\main\\webapp\\";
        String myId = "123456789";

//        for (int i = 1; i < 11; i++) {
//
//            myId = myId + i;
//            CoreService.generateQRCode(myId, pathName);
//        }

        //分成5组条形码
        List<CodeEntity> codeEntityList1 = CoreService.generateCodeList(myId, 1, pathName);
        List<CodeEntity> codeEntityList2 = CoreService.generateCodeList(myId, 2, pathName);
        List<CodeEntity> codeEntityList3 = CoreService.generateCodeList(myId, 3, pathName);
        List<CodeEntity> codeEntityList4 = CoreService.generateCodeList(myId, 4, pathName);
        List<CodeEntity> codeEntityList5 = CoreService.generateCodeList(myId, 5, pathName);
    }
}
