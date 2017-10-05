package com.fruit.web.weixin.model;

import com.fruit.core.persistence.convention.annotation.Column;
import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;
import com.fruit.core.persistence.convention.annotation.Table;

@Table(name = "weixin_userinfo", schema = "")
@SuppressWarnings("serial")
public class WeiXinUserInfo implements java.io.Serializable {
	
	/**id*/
	@Id
	@GeneratedValue(generator = "UUID")
	private java.lang.String id;
	/**是否订阅*/
	private java.lang.String subscribe;
	/**商家标识*/
	private java.lang.String bussmark;
	/**微信id*/
	private java.lang.String openid;
	/**昵称*/
	private java.lang.String nickname;
	/**性别*/
	private java.lang.String sex;
	/**省*/
	private java.lang.String province;
	/**市*/
	private java.lang.String city;
	/**区*/
	private java.lang.String country;
	/**头像*/
	private java.lang.String headimgurl;
	/**订阅时间*/
	private java.util.Date subscribetime;
	/**备注名称*/
	private java.lang.String bzname;
	/**分组id*/
	private java.lang.String groupid;
	
	private java.lang.String remark;
	/**添加时间*/
	private java.util.Date addtime;
	/**账户id*/
	private java.lang.String accountid;
	/**创建人名称 */
	private java.lang.String createname;
	/**创建日期*/
	private java.util.Date createdate;
	/**修改人名称*/
	private java.lang.String updatename;
	/**修改日期*/
	private java.util.Date updatedate;
	
	
	public WeiXinUserInfo()
	  {
	  }

	public WeiXinUserInfo(String subscribe, String openid, String nickname,String remark, String sex, String city, String province, String country, String headimgurl, java.util.Date subscribetime)
	  {
	    this.subscribe = subscribe;
	    this.openid = openid;
	    this.nickname = nickname;
	    this.remark = remark;
	    this.sex = sex;
	    this.city = city;
	    this.province = province;
	    this.country = country;
	    this.headimgurl = headimgurl;
	    this.subscribetime = subscribetime;
	  }
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
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
	 *@return: java.lang.String  是否订阅
	 */
	@Column(name ="SUBSCRIBE",nullable=true,length=100)
	public java.lang.String getSubscribe(){
		return this.subscribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否订阅
	 */
	public void setSubscribe(java.lang.String subscribe){
		this.subscribe = subscribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商家标识
	 */
	@Column(name ="BUSSMARK",nullable=true,length=2)
	public java.lang.String getBussmark(){
		return this.bussmark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商家标识
	 */
	public void setBussmark(java.lang.String bussmark){
		this.bussmark = bussmark;
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
	 *@return: java.lang.String  昵称
	 */
	@Column(name ="NICKNAME",nullable=true,length=200)
	public java.lang.String getNickname(){
		return this.nickname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  昵称
	 */
	public void setNickname(java.lang.String nickname){
		this.nickname = nickname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=200)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
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
	 *@return: java.lang.String  头像
	 */
	@Column(name ="HEADIMGURL",nullable=true,length=200)
	public java.lang.String getHeadimgurl(){
		return this.headimgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setHeadimgurl(java.lang.String headimgurl){
		this.headimgurl = headimgurl;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  订阅时间
	 */
	@Column(name ="SUBSCRIBETIME",nullable=true)
	public java.util.Date getSubscribetime(){
		return this.subscribetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  订阅时间
	 */
	public void setSubscribetime(java.util.Date subscribetime){
		this.subscribetime = subscribetime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注名称
	 */
	@Column(name ="BZNAME",nullable=true,length=200)
	public java.lang.String getBzname(){
		return this.bzname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注名称
	 */
	public void setBzname(java.lang.String bzname){
		this.bzname = bzname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分组id
	 */
	@Column(name ="GROUPID",nullable=true,length=100)
	public java.lang.String getGroupid(){
		return this.groupid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分组id
	 */
	public void setGroupid(java.lang.String groupid){
		this.groupid = groupid;
	}
	
	public java.lang.String getRemark() {
		return remark;
	}
	@Column(name ="remark",nullable=true,length=100)
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  添加时间
	 */
	@Column(name ="ADDTIME",nullable=true)
	public java.util.Date getAddtime(){
		return this.addtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  添加时间
	 */
	public void setAddtime(java.util.Date addtime){
		this.addtime = addtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户id
	 */
	@Column(name ="ACCOUNTID",nullable=false,length=100)
	public java.lang.String getAccountid(){
		return this.accountid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户id
	 */
	public void setAccountid(java.lang.String accountid){
		this.accountid = accountid;
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
