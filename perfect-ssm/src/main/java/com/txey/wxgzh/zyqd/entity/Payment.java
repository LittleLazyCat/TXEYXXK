package com.txey.wxgzh.zyqd.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 住院缴款信息
 *
 * @author AJ
 */
public class Payment {
    private int zyh;            //住院号
    private Date jkrq;          //缴款日期
    private BigDecimal jkje;    //缴款金额

    public Payment() {
    }

    public Payment(Integer zyh, Date jkrq, BigDecimal jkje) {
        this.zyh = zyh;
        this.jkrq = jkrq;
        this.jkje = jkje;
    }

    public Integer getZyh() {
        return zyh;
    }

    public void setZyh(Integer zyh) {
        this.zyh = zyh;
    }

    public Date getJkrq() {
        return jkrq;
    }

    public void setJkrq(Date jkrq) {
        this.jkrq = jkrq;
    }

    public BigDecimal getJkje() {
        return jkje;
    }

    public void setJkje(BigDecimal jkje) {
        this.jkje = jkje;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "zyh=" + zyh +
                ", jkrq=" + jkrq +
                ", jkje=" + jkje +
                '}';
    }
}
