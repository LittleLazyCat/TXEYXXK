package com.fruit.web.mapper.system.count;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SystemLoginMapper {

	@Select("select DATE_FORMAT(create_date, '%Y-%m-%d %H:%i:%s') AS tim,system_login_log.* from system_login_log where 1=1 and CREATE_DATE like #{now} order by CREATE_DATE desc")
	public List<Map<String, Object>> selectNowCount(String now);

	@Select("select DATE_FORMAT(create_date, '%Y-%m-%d %H:%i:%s') AS tim,system_login_log.* from system_login_log where 1=1 and CREATE_DATE>=#{begin_time} and CREATE_DATE<=#{end_time} order by CREATE_DATE desc")
	public List<Map<String, Object>> selectBetweenCount(@Param("begin_time") String beginTime,@Param("end_time") String endTime);

}
