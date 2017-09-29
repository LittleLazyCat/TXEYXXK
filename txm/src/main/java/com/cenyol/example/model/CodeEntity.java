package com.cenyol.example.model;

public class CodeEntity {
    //标识码
    private String codeNumber;
    //条形码文件名
    private String imageName;

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
