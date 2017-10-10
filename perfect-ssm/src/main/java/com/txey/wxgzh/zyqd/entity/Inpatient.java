package com.txey.wxgzh.zyqd.entity;

/**
 * 住院病人信息
 *
 * @author AJ
 *
 */
public class Inpatient {
    private String zyhm;    //住院号码
    private int zyh;        //住院号
    private String jtdh;    //家庭电话
    private String sfzh;    //身份证号
    private String brxm;    //病人姓名

    public Inpatient() {
    }

    public Inpatient(String zyhm, Integer zyh, String jtdh, String sfzh, String brxm) {
        this.zyhm = zyhm;
        this.zyh = zyh;
        this.jtdh = jtdh;
        this.sfzh = sfzh;
        this.brxm = brxm;
    }

    public String getZyhm() {
        return zyhm;
    }

    public void setZyhm(String zyhm) {
        this.zyhm = zyhm;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public String getJtdh() {
        return jtdh;
    }

    public void setJtdh(String jtdh) {
        this.jtdh = jtdh;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    @Override
    public String toString() {
        return "Inpatient{" +
                "zyhm='" + zyhm + '\'' +
                ", zyh=" + zyh +
                ", jtdh='" + jtdh + '\'' +
                ", sfzh='" + sfzh + '\'' +
                ", brxm='" + brxm + '\'' +
                '}';
    }
}
