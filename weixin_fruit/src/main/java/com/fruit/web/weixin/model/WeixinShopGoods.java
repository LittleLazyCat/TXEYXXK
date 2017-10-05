package com.fruit.web.weixin.model;

import java.io.Serializable;
import java.util.Date;

import com.fruit.core.persistence.convention.annotation.Column;
import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;
import com.fruit.core.persistence.convention.annotation.Table;

@Table(name = "weixin_shop_goods", schema = "")
public class WeixinShopGoods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "ID", nullable = false, length = 36)
	private String id;
	private String createName;
	private Date createDate;
	private String updateName;
	private Date updateDate;

	private String title;

	private String titleImg;

	private String standard;
	
	private String sequence;
	
	private String descriptions;
	
	private String outStock;
	
	private Double price;

	private Double realPrice;

	private Double sale;

	private Integer sellCount;
	private Integer discussCount;
	private Integer goodCount;
	private Integer badCount;
	private String statement;
	private Date shelveTime;
	private Date removeTime;

	private String expressName;

	private Double expressPrice;

	private String sellerId;
	private String categoryId;
	private String accountid;

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CREATE_NAME", nullable = true, length = 50)
	public String getCreateName() {
		return this.createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	@Column(name = "CREATE_DATE", nullable = true, length = 20)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "UPDATE_NAME", nullable = true, length = 50)
	public String getUpdateName() {
		return this.updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	@Column(name = "UPDATE_DATE", nullable = true, length = 20)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "TITLE", nullable = true, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TITLE_IMG", nullable = true, length = 100)
	public String getTitleImg() {
		return this.titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	@Column(name = "STANDARD", nullable = true, length = 100)
	public String getStandard() {
		return this.standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}
	@Column(name = "SEQUENCE", nullable = true, length = 1000)
	public String getSequence() {
		return this.sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	@Column(name = "DESCRIPTIONS", nullable = true, length = 5000)
	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
	@Column(name = "OUT_STOCK", nullable = true, length = 2)
	public String getOutStock() {
		return this.outStock;
	}

	public void setOutStock(String outStock) {
		this.outStock = outStock;
	}
	
	@Column(name = "PRICE", nullable = true, scale = 2, length = 18)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "REAL_PRICE", nullable = true, scale = 2, length = 18)
	public Double getRealPrice() {
		return this.realPrice;
	}

	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}

	@Column(name = "SALE", nullable = true, scale = 2, length = 18)
	public Double getSale() {
		return this.sale;
	}

	public void setSale(Double sale) {
		this.sale = sale;
	}

	@Column(name = "SELL_COUNT", nullable = true, length = 11)
	public Integer getSellCount() {
		return this.sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

	@Column(name = "DISCUSS_COUNT", nullable = true, length = 11)
	public Integer getDiscussCount() {
		return this.discussCount;
	}

	public void setDiscussCount(Integer discussCount) {
		this.discussCount = discussCount;
	}

	@Column(name = "GOOD_COUNT", nullable = true, length = 11)
	public Integer getGoodCount() {
		return this.goodCount;
	}

	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}

	@Column(name = "BAD_COUNT", nullable = true, length = 11)
	public Integer getBadCount() {
		return this.badCount;
	}

	public void setBadCount(Integer badCount) {
		this.badCount = badCount;
	}

	@Column(name = "STATEMENT", nullable = true, length = 32)
	public String getStatement() {
		return this.statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Column(name = "SHELVE_TIME", nullable = true, length = 32)
	public Date getShelveTime() {
		return this.shelveTime;
	}

	public void setShelveTime(Date shelveTime) {
		this.shelveTime = shelveTime;
	}

	@Column(name = "REMOVE_TIME", nullable = true, length = 32)
	public Date getRemoveTime() {
		return this.removeTime;
	}

	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}

	@Column(name = "EXPRESS_NAME", nullable = true, length = 32)
	public String getExpressName() {
		return this.expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	@Column(name = "EXPRESS_PRICE", nullable = true, scale = 2, length = 18)
	public Double getExpressPrice() {
		return this.expressPrice;
	}

	public void setExpressPrice(Double expressPrice) {
		this.expressPrice = expressPrice;
	}

	@Column(name = "SELLER_ID", nullable = true, length = 36)
	public String getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
}
