package com.fruit.web.weixin.model;

import com.fruit.core.persistence.convention.annotation.Column;
import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;
import com.fruit.core.persistence.convention.annotation.Table;


/**   
 * @Title: Entity
 * @Description: 主键ID
 * @date 2015-03-26 02:28:22
 * @version V1.0   
 *
 */
@Table(name = "orderuserinfo")
@SuppressWarnings("serial")
public class OrderUserInfo implements java.io.Serializable {
	public OrderUserInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderUserInfo(String openid, String username, String country, String effectiveflag) {
		super();
		this.openid = openid;
		this.username = username;
		this.country = country;
		this.effectiveflag = effectiveflag;
	}

	/**id*/
	@Id
	@GeneratedValue(generator = "UUID")
	private java.lang.String id;
	/**微信id*/
	private java.lang.String openid;
	/**姓名*/
	private java.lang.String username;
	/**电话*/
	private java.lang.String phone;
	/**省*/
	private java.lang.String province;
	/**市*/
	private java.lang.String city;
	/**区*/
	private java.lang.String country;
	/**地址*/
	private java.lang.String address;
	/**订单id*/
	private java.lang.String orderid;
	/**总金额*/
	private java.lang.Double amounttotal;
	/**余额*/
	private java.lang.Double balance;
	/**下单次数*/
	private java.lang.String ordercount;
	/**评价次数*/
	private java.lang.String evaluationcount;
	/**用户等级*/
	private java.lang.String uselevel;
	/**有效标志*/
	private java.lang.String effectiveflag;
	/**创建人名称 */
	private java.lang.String createname;
	/**创建日期*/
	private java.util.Date createdate;
	/**修改人名称*/
	private java.lang.String updatename;
	/**修改日期*/
	private java.util.Date updatedate;
	
	
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信id
	 */
	@Column(name ="OPENID",nullable=false,length=200)
	public java.lang.String getOpenid(){
		return this.openid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信id
	 */
	public void setOpenid(java.lang.String openid){
		this.openid = openid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="USERNAME",nullable=true,length=200)
	public java.lang.String getUsername(){
		return this.username;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	@Column(name ="PHONE",nullable=true,length=200)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省
	 */
	@Column(name ="PROVINCE",nullable=true,length=200)
	public java.lang.String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  市
	 */
	@Column(name ="CITY",nullable=true,length=200)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  市
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区
	 */
	@Column(name ="COUNTRY",nullable=true,length=200)
	public java.lang.String getCountry(){
		return this.country;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区
	 */
	public void setCountry(java.lang.String country){
		this.country = country;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=200)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单id
	 */
	@Column(name ="ORDERID",nullable=true,length=200)
	public java.lang.String getOrderid(){
		return this.orderid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单id
	 */
	public void setOrderid(java.lang.String orderid){
		this.orderid = orderid;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  总金额
	 */
	@Column(name ="AMOUNTTOTAL",nullable=true,precision=22)
	public java.lang.Double getAmounttotal(){
		return this.amounttotal;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  总金额
	 */
	public void setAmounttotal(java.lang.Double amounttotal){
		this.amounttotal = amounttotal;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  余额
	 */
	@Column(name ="BALANCE",nullable=true,precision=22)
	public java.lang.Double getBalance(){
		return this.balance;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  余额
	 */
	public void setBalance(java.lang.Double balance){
		this.balance = balance;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  下单次数
	 */
	@Column(name ="ORDERCOUNT",nullable=true,length=200)
	public java.lang.String getOrdercount(){
		return this.ordercount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  下单次数
	 */
	public void setOrdercount(java.lang.String ordercount){
		this.ordercount = ordercount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评价次数
	 */
	@Column(name ="EVALUATIONCOUNT",nullable=true,length=200)
	public java.lang.String getEvaluationcount(){
		return this.evaluationcount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评价次数
	 */
	public void setEvaluationcount(java.lang.String evaluationcount){
		this.evaluationcount = evaluationcount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户等级
	 */
	@Column(name ="USELEVEL",nullable=true,length=100)
	public java.lang.String getUselevel(){
		return this.uselevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户等级
	 */
	public void setUselevel(java.lang.String uselevel){
		this.uselevel = uselevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  有效标志
	 */
	@Column(name ="EFFECTIVEFLAG",nullable=false,length=100)
	public java.lang.String getEffectiveflag(){
		return this.effectiveflag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  有效标志
	 */
	public void setEffectiveflag(java.lang.String effectiveflag){
		this.effectiveflag = effectiveflag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称 
	 */
	@Column(name ="CREATENAME",nullable=true,length=100)
	public java.lang.String getCreatename(){
		return this.createname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称 
	 */
	public void setCreatename(java.lang.String createname){
		this.createname = createname;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */
	@Column(name ="CREATEDATE",nullable=true)
	public java.util.Date getCreatedate(){
		return this.createdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreatedate(java.util.Date createdate){
		this.createdate = createdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人名称
	 */
	@Column(name ="UPDATENAME",nullable=true,length=100)
	public java.lang.String getUpdatename(){
		return this.updatename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人名称
	 */
	public void setUpdatename(java.lang.String updatename){
		this.updatename = updatename;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改日期
	 */
	@Column(name ="UPDATEDATE",nullable=true)
	public java.util.Date getUpdatedate(){
		return this.updatedate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改日期
	 */
	public void setUpdatedate(java.util.Date updatedate){
		this.updatedate = updatedate;
	}
}
