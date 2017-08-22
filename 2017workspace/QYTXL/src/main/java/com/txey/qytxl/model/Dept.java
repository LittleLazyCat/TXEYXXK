package com.txey.qytxl.model;

import java.io.Serializable;

/**
 * 
 * 科室实体类
 * 
 * @author Alex Jones
 * 
 * @Time 2017-07-23 12:09:01
 *
 * 
 * 
 */
public class Dept implements Serializable {
	private Integer ksid;// 科室ID
	private String ksmc;// 科室名称
	private String ksmcpy;// 科室名称拼音
	private Integer kslxid;// 科室类型ID
	private String yddh;// 移动电话
	private String dxdh;// 电信电话
	private String ksbz;// 备注

	public Dept() {
		
	}

	public Dept(Integer ksid, String ksmc, String ksmcpy, Integer kslxid, String yddh, String dxdh, String ksbz) {
		super();
		this.ksid = ksid;
		this.ksmc = ksmc;
		this.ksmcpy = ksmcpy;
		this.kslxid = kslxid;
		this.yddh = yddh;
		this.dxdh = dxdh;
		this.ksbz = ksbz;
	}

	public Integer getKsid() {
		return ksid;
	}

	public void setKsid(Integer ksid) {
		this.ksid = ksid;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getKsmcpy() {
		return ksmcpy;
	}

	public void setKsmcpy(String ksmcpy) {
		this.ksmcpy = ksmcpy;
	}

	public Integer getKslxid() {
		return kslxid;
	}

	public void setKslxid(Integer kslxid) {
		this.kslxid = kslxid;
	}

	public String getYddh() {
		return yddh;
	}

	public void setYddh(String yddh) {
		this.yddh = yddh;
	}

	public String getDxdh() {
		return dxdh;
	}

	public void setDxdh(String dxdh) {
		this.dxdh = dxdh;
	}

	public String getKsbz() {
		return ksbz;
	}

	public void setKsbz(String ksbz) {
		this.ksbz = ksbz;
	}
 

	@Override
	public String toString() {
		return "Dept [ksid=" + ksid + ", ksmc=" + ksmc + ", ksmcpy=" + ksmcpy + ", kslxid=" + kslxid + ", yddh=" + yddh
				+ ", dxdh=" + dxdh + ", ksbz=" + ksbz + "]";
	}

}
