package com.txey.qytxl.model;
//员工

import java.io.Serializable;

/**
 * 员工信息实体类
 *
 * @author Alex Jones
 * @Time 2017-07-23 12:24:01
 */
public class Employee implements Serializable {
    private Integer ygid;// 员工ID
    private String ygbh;//员工编号
    private String ygxm;// 员工姓名
    private String ksmc;// 科室名称
    private String xmpy;// 姓名拼音
    private Integer ygxb;// 员工性别
    private Integer ksid;// 科室ID
    private String sjch;// 手机长号
    private String xnw;// 虚拟网
    private String userName;// 用户名
    private String password;// 密码

    public Employee() {
    }

    public Employee(Integer ygid, String ygbh,String ygxm, String xmpy, Integer ygxb, Integer ksid, String sjch, String xnw,
                    String userName, String password) {
        super();
        this.ygid = ygid;
        this.ygbh = ygbh;
        this.ygxm = ygxm;
        this.xmpy = xmpy;
        this.ygxb = ygxb;
        this.ksid = ksid;
        this.sjch = sjch;
        this.xnw = xnw;
        this.userName = userName;
        this.password = password;
    }

    public Employee(Integer ygid,String ygbh, String ygxm, String ksmc, String xmpy, Integer ygxb, Integer ksid, String sjch,
                    String xnw, String userName, String password) {
        super();
        this.ygid = ygid;
        this.ygxm = ygxm;
        this.ygbh = ygbh;
        this.ksmc = ksmc;
        this.xmpy = xmpy;
        this.ygxb = ygxb;
        this.ksid = ksid;
        this.sjch = sjch;
        this.xnw = xnw;
        this.userName = userName;
        this.password = password;
    }


    public void setYgbh(String ygbh) {
        this.ygbh = ygbh;
    }

    public String getYgbh() {
        return ygbh;
    }

    public Integer getYgxb() {
        return ygxb;
    }

    public void setYgxb(Integer ygxb) {
        this.ygxb = ygxb;
    }

    public String getSjch() {
        return sjch;
    }

    public void setSjch(String sjch) {
        this.sjch = sjch;
    }

    public String getXnw() {
        return xnw;
    }

    public void setXnw(String xnw) {
        this.xnw = xnw;
    }

    public Integer getYgid() {
        return ygid;
    }

    public void setYgid(Integer ygid) {
        this.ygid = ygid;
    }

    public String getYgxm() {
        return ygxm;
    }

    public void setYgxm(String ygxm) {
        this.ygxm = ygxm;
    }

    public String getXmpy() {
        return xmpy;
    }

    public void setXmpy(String xmpy) {
        this.xmpy = xmpy;
    }

    public Integer getKsid() {
        return ksid;
    }

    public void setKsid(Integer ksid) {
        this.ksid = ksid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ygid=" + ygid +
                ", ygbh='" + ygbh + '\'' +
                ", ygxm='" + ygxm + '\'' +
                ", ksmc='" + ksmc + '\'' +
                ", xmpy='" + xmpy + '\'' +
                ", ygxb=" + ygxb +
                ", ksid=" + ksid +
                ", sjch='" + sjch + '\'' +
                ", xnw='" + xnw + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
