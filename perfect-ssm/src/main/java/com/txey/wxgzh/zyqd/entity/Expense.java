package com.txey.wxgzh.zyqd.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 住院费用信息
 *
 * @author AJ
 */
public class Expense {
    private int zyh;            //住院号
    private int fyxh;           //费用序号
    private Date jfrq;          //计费日期
    private BigDecimal fydj;    //费用单价
    private BigDecimal fysl;    //费用数量
    private BigDecimal zjje;    //总计金额
    private BigDecimal zfje;    //自费金额
    private int fyxm;           //大类序号
    private String sfmc;        //大类名称

    public Expense() {

    }

    public Expense(Integer zyh, Integer fyxh, Date jfrq, BigDecimal fydj, BigDecimal fysl, BigDecimal zjje, BigDecimal zfje, Integer fyxm, String sfmc) {
        this.zyh = zyh;
        this.fyxh = fyxh;
        this.jfrq = jfrq;
        this.fydj = fydj;
        this.fysl = fysl;
        this.zjje = zjje;
        this.zfje = zfje;
        this.fyxm = fyxm;
        this.sfmc = sfmc;
    }


    public int getZyh() {
        return zyh;
    }

    public void setZyh(int zyh) {
        this.zyh = zyh;
    }

    public int getFyxh() {
        return fyxh;
    }

    public void setFyxh(int fyxh) {
        this.fyxh = fyxh;
    }

    public Date getJfrq() {
        return jfrq;
    }

    public void setJfrq(Date jfrq) {
        this.jfrq = jfrq;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }

    public BigDecimal getFysl() {
        return fysl;
    }

    public void setFysl(BigDecimal fysl) {
        this.fysl = fysl;
    }

    public BigDecimal getZjje() {
        return zjje;
    }

    public void setZjje(BigDecimal zjje) {
        this.zjje = zjje;
    }

    public BigDecimal getZfje() {
        return zfje;
    }

    public void setZfje(BigDecimal zfje) {
        this.zfje = zfje;
    }

    public int getFyxm() {
        return fyxm;
    }

    public void setFyxm(int fyxm) {
        this.fyxm = fyxm;
    }

    public String getSfmc() {
        return sfmc;
    }

    public void setSfmc(String sfmc) {
        this.sfmc = sfmc;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "zyh=" + zyh +
                ", fyxh=" + fyxh +
                ", jfrq=" + jfrq +
                ", fydj=" + fydj +
                ", fysl=" + fysl +
                ", zjje=" + zjje +
                ", zfje=" + zfje +
                ", fyxm=" + fyxm +
                ", sfmc='" + sfmc + '\'' +
                '}';
    }
}
