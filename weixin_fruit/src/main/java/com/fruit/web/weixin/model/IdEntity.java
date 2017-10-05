package com.fruit.web.weixin.model;

import com.fruit.core.persistence.convention.annotation.Column;
import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;

public abstract class IdEntity {
	
	@Id
	@GeneratedValue(generator = "UUID")
	private String id;

	@Column(name ="ID",nullable=false,length=32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
