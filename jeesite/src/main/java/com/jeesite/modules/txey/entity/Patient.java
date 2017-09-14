package com.jeesite.modules.txey.entity;

public class Patient {
    private String brxm;
    private String csny;
    private String sfzh;

    public Patient() {
    }

    public Patient(String brxm, String csny, String sfzh) {
        this.brxm = brxm;
        this.csny = csny;
        this.sfzh = sfzh;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getCsny() {
        return csny;
    }

    public void setCsny(String csny) {
        this.csny = csny;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "brxm='" + brxm + '\'' +
                ", csny='" + csny + '\'' +
                ", sfzh='" + sfzh + '\'' +
                '}';
    }
}
