package com.report.common.model.query;

import java.io.Serializable;

/**
 * 
 * @author lishun
 *
 */
public class ReportCommonConVO implements Serializable {

	private static final long serialVersionUID = -1018169764573946550L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 报表标志
	 */
	private String toolFlag;
	/**
	 * 条件标志
	 */
	private String conFlag;
	/**
	 * 匹配sql条件
	 */
	private String conWhere;
	/**
	 * 参数值
	 */
	private String conValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToolFlag() {
		return toolFlag;
	}

	public void setToolFlag(String toolFlag) {
		this.toolFlag = toolFlag;
	}

	public String getConFlag() {
		return conFlag;
	}

	public void setConFlag(String conFlag) {
		this.conFlag = conFlag;
	}

	public String getConWhere() {
		return conWhere;
	}

	public void setConWhere(String conWhere) {
		this.conWhere = conWhere;
	}

	public String getConValue() {
		return conValue;
	}

	public void setConValue(String conValue) {
		this.conValue = conValue;
	}
}
