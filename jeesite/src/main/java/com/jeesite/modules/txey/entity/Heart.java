package com.jeesite.modules.txey.entity;

import java.util.Date;

public class Heart {
    private int fyxh;//费用序号
    private String fymc;//费用名称
    private Date sfrq;//收费日期
    private int yldj;//医疗单价
    private int ylsl;//医疗数量
    private int hjje;//合计金额
    private Date ksrq;//开始日期
    private Date jsrq;//结束日期


    public Heart() {
    }

    public Heart(Integer fyxh, String fymc, Date sfrq, Integer yldj, Integer ylsl, Integer hjje) {
        this.fyxh = fyxh;
        this.fymc = fymc;
        this.sfrq = sfrq;
        this.yldj = yldj;
        this.ylsl = ylsl;
        this.hjje = hjje;
    }

    public int getFyxh() {
        return fyxh;
    }

    public void setFyxh(int fyxh) {
        this.fyxh = fyxh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public Date getSfrq() {
        return sfrq;
    }

    public void setSfrq(Date sfrq) {
        this.sfrq = sfrq;
    }

    public int getYldj() {
        return yldj;
    }

    public void setYldj(int yldj) {
        this.yldj = yldj;
    }

    public int getYlsl() {
        return ylsl;
    }

    public void setYlsl(int ylsl) {
        this.ylsl = ylsl;
    }

    public int getHjje() {
        return hjje;
    }

    public void setHjje(int hjje) {
        this.hjje = hjje;
    }

    public Date getbeginDate() {
        return ksrq;
    }

    public void setbeginDate(Date ksrq) {
        this.ksrq = ksrq;
    }

    public Date getendDate() {
        return jsrq;
    }

    public void setendDate(Date jsrq) {
        this.jsrq = jsrq;
    }

    @Override
    public String toString() {
        return "Heart{" +
                "fyxh=" + fyxh +
                ", fymc='" + fymc + '\'' +
                ", sfrq=" + sfrq +
                ", yldj=" + yldj +
                ", ylsl=" + ylsl +
                ", hjje=" + hjje +
                '}';
    }
}
