package com.cenyol.example.service;

import com.cenyol.example.model.CodeEntity;
import com.cenyol.example.utils.QRCodeUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoreService {

    /**
     * 分组进行条形码生成
     *
     * @param myId
     * @param groupId
     * @param pathName
     * @author AJ
     */
    public static List<CodeEntity> generateCodeList(String myId, int groupId, String pathName) {

        //用于临时存储1号条形码标识
        String tempCode1 = "0";
        String tempCode2 = "0";


        //条形码实体数组
        List<CodeEntity> codeEntities = new ArrayList<CodeEntity>();


        if (groupId == 1) {
            tempCode1 = myId + "0";

            tempCode2 = myId + "1";

        } else if (groupId == 2) {
            tempCode1 = myId + "2";

            tempCode2 = myId + "3";

        } else if (groupId == 3) {
            tempCode1 = myId + "4";

            tempCode2 = myId + "5";
        } else if (groupId == 4) {
            tempCode1 = myId + "6";

            tempCode2 = myId + "7";
        } else if(groupId==5){
            tempCode1 = myId + "8";

            tempCode2 = myId + "9";
        }

        CodeEntity codeEntity1 = CoreService.generateCodeEntity(tempCode1, pathName);
        codeEntities.add(codeEntity1);
        CodeEntity codeEntity2 = CoreService.generateCodeEntity(tempCode2, pathName);
        codeEntities.add(codeEntity2);

        return codeEntities;
    }


    /**
     * 生成一维码实体
     *
     * @param tempCode
     * @param pathName
     * @author AJ
     */
    public static CodeEntity generateCodeEntity(String tempCode, String pathName) {
        //条形码实体
        CodeEntity codeEntity = new CodeEntity();
        //生成条形码
        CoreService.generateQRCode(tempCode, pathName);
        //实体赋值
        codeEntity.setCodeNumber(tempCode);
        codeEntity.setImageName(tempCode + ".png");

        return codeEntity;
    }


    /**
     * 生成一维码，写到文件中
     *
     * @param myId
     * @param pathName
     * @author AJ
     */
    public static String generateQRCode(String myId, String pathName) {

        //组合生成条形码图片存放路径
        pathName += "txmimages\\";

        String imageName = myId + ".png";
        try {
            QRCodeUtil.getBarcodeWriteFile(myId, 300, 120, new File(pathName + imageName));
            //System.out.println("一维码生成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageName;
    }
}
