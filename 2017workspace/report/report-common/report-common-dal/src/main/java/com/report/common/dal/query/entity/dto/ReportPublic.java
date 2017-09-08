package com.report.common.dal.query.entity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 报表公共信息
 * @author lishun
 * @since 2017年5月3日 下午7:37:02
 */
@Data
public class ReportPublic implements Serializable {

	private static final long serialVersionUID = 727016893684040578L;
	
	/** 主键 */
	private Integer id;
	/** 报表标志 */
    private String toolFlag;
	/** 表格标题 */
    private String toolTitle;
	/** 中文列名 */
    private String toolCColumn;
	/** 英文列名 */
    private String toolEColumn;
	/** 当前页汇总列 */
    private String toolGather;
	/** 列格式化 */
    private String toolFormat;
	/** 按小时sqlId */
    private String toolHSqlId;
	/** 按天sqlId */
    private String toolDSqlId;
	/** 按周sqlId */
    private String toolWSqlId;
	/** 按月sqlId */
    private String toolMSqlId;
	/** 按季sqlId */
    private String toolQSqlId;
	/** 按年sqlId */
    private String toolYSqlId;
	/** 汇总块展示行数 */
    private Integer staticRowNum;
	/** 汇总块sqlId */
    private Long staticSql;
	/** 汇总块列名 */
    private String staticCcolumn;
	/** 创建时间 */
    private Date createTime;
	/** 更新时间 */
    private Date updateTime;
}
