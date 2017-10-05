package com.fruit.web.model;

import java.util.Date;

import com.fruit.core.persistence.convention.annotation.GeneratedValue;
import com.fruit.core.persistence.convention.annotation.Id;

public class SystemLog {
	
	@Id
	@GeneratedValue(generator = "JDBC")
    private Integer id;

    private String method;
    
    private String name;
    
    private String ip;

    private String time;

    private String clss;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getIp() {
		return ip;
	}
    
    public void setIp(String ip) {
		this.ip = ip;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getName() {
		return name;
	}

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getClss() {
        return clss;
    }

    public void setClss(String clss) {
        this.clss = clss == null ? null : clss.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}