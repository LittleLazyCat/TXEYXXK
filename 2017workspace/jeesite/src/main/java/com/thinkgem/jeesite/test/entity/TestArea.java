package com.thinkgem.jeesite.test.entity;

public class TestArea {
    private String code;
    private String capital;
    private String region;
    private String province;
    private String city;
    private String district;

    public TestArea() {
    }

    public TestArea(String code, String capital, String region, String province, String city, String district) {
        this.code = code;
        this.capital = capital;
        this.region = region;
        this.province = province;
        this.city = city;
        this.district = district;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDiatrict() {
        return district;
    }

    public void setDiatrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "TestArea{" +
                "code='" + code + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", diatrict='" + district + '\'' +
                '}';
    }
}
