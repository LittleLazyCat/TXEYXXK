package com.fruit.web.weixin.model;

import java.io.Serializable;

import com.fruit.core.persistence.convention.annotation.Column;
import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;
import com.fruit.core.persistence.convention.annotation.Table;


@Table(name = "weixin_shop_cart")
public class WeixinShopCart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private String id;
	private String goodsProperty;
	private Double buyPrice;
	private Integer count;
	private Double total;
	private String accountid;

	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "GOODS_PROPERTY", nullable = true, length = 200)
	public String getGoodsProperty() {
		return this.goodsProperty;
	}

	public void setGoodsProperty(String goodsProperty) {
		this.goodsProperty = goodsProperty;
	}

	@Column(name = "BUY_PRICE", nullable = true, precision = 10, scale = 2)
	public Double getBuyPrice() {
		return this.buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	@Column(name = "COUNT", nullable = true, precision = 10, scale = 0)
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "TOTAL", nullable = true, precision = 10, scale = 2)
	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getAccountid() {
		return this.accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
}
