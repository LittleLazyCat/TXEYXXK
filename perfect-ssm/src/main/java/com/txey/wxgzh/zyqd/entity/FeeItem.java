package com.txey.wxgzh.zyqd.entity;
/**
 * 收费项目信息
 *
 * @author AJ
 *
 */
public class FeeItem {
    private int fylb;       //费用类别
    private String sfmc;    //大类的收费名称

    public FeeItem() {
    }

    public FeeItem(Integer fylb, String sfmc) {
        this.fylb = fylb;
        this.sfmc = sfmc;
    }

    public Integer getFylb() {
        return fylb;
    }

    public void setFylb(Integer fylb) {
        this.fylb = fylb;
    }

    public String getSfmc() {
        return sfmc;
    }

    public void setSfmc(String sfmc) {
        this.sfmc = sfmc;
    }
}
