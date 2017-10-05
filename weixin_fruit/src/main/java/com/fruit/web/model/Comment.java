package com.fruit.web.model;

import java.util.Date;

import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;

public class Comment {
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

    private String comment;

    private Integer uId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}