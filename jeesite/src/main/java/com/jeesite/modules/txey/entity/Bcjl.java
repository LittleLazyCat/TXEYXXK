package com.jeesite.modules.txey.entity;

import oracle.jdbc.OracleNClob;
import oracle.sql.NCLOB;

import java.math.BigDecimal;

/*
病程记录
 */
public class Bcjl {

    private String bah; //病案号
    private String dname;   //医生姓名
    private String jlsj;    //记录时间
    private String jlnr;    //记录内容
    private BigDecimal typeid;     //病程类型


    public Bcjl(String dname, String jlsj, String jlnr, BigDecimal typeid) {
        this.dname = dname;
        this.jlsj = jlsj;
        this.jlnr = jlnr;
        this.typeid = typeid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJlsj() {
        return jlsj;
    }

    public void setJlsj(String jlsj) {
        this.jlsj = jlsj;
    }

    public String getJlnr() {
        return jlnr;
    }

    public void setJlnr(String jlnr) {
        this.jlnr = jlnr;
    }

    public BigDecimal getTypeid() {
        return typeid;
    }

    public void setTypeid(BigDecimal typeid) {
        this.typeid = typeid;
    }

    public String getBah() {
        return bah;
    }

    public void setBah(String bah) {
        this.bah = bah;
    }

    @Override
    public String toString() {
        return "Bcjl{" +
                "bah='" + bah + '\'' +
                ", dname='" + dname + '\'' +
                ", jlsj='" + jlsj + '\'' +
                ", jlnr='" + jlnr + '\'' +
                ", typeid=" + typeid +
                '}';
    }
}
